package View;

import Helper.*;
import Model.Course;
import Model.Operator;
import Model.Patika;
import Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPopupMenu patikamenu;
    private JPanel wrapper;
    private JTabbedPane pnl_UserList;
    private JLabel lbl_welcome;
    private JButton btn_cikis;
    private JScrollPane scr_userList;
    private JPanel pnl_Users;
    private JTable tbl_userList;
    private JTextField fld_name;
    private JTextField fld_user_names;
    private JTextField fld_password;
    private JTextField fld_type;
    private JButton btn_add;
    private JLabel lbl_pass;
    private JTextField txt_id;
    private JButton btn_user_delete;
    private JPanel pnl_User;
    private JLabel lbl_id;
    private JTextField txt_sh_name;
    private JTextField txt_sh_username;
    private JTextField txt_sh_type;
    private JButton btn_search;
    private JPanel pnl_patikalist;
    private JScrollPane scrl_patikalist;
    private JTable tbl_patikalist;
    private JPanel pnl_patikaadd;
    private JTextField fld_patikaname;
    private JButton ekleButton;
    private JPanel pnl_top;
    private JPanel pnl_CourseList;
    private JScrollPane scrl_courselist;
    private JTable tbl_course_list;
    private JPanel pnl_courseadd;
    private JTextField fld_coursename;
    private JTextField fld_courselang;
    //private JLabel Patika;
    private JTextField fld_patika;
    private JTextField fld_educator;
    private JButton btn_course_add;
    private DefaultTableModel mdl_user_list;
    private Object[] row_User_List;
    private final Operator operator;
    private DefaultTableModel mdl_patikalist;
    private Object[] row_patikalist;
    private DefaultTableModel mdl_course_list;
    private Object[] row_courseList;



    public OperatorGUI(Operator operator){
        this.operator=operator;
        Helper.setLayout();
        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenterPoint("x",getSize()), Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldiniz " + operator.getName() + "!");

        //ModelUserList
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] col_user_list = {"ID" , "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_User_List = new Object[col_user_list.length];
        loadUserModel();


        tbl_userList.setModel(mdl_user_list);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int userid = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                String name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                String username = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                String pass = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                String type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                if(User.update(userid,name,username,pass,type)){
                    Helper.showMsg("done");
                    loadUserModel();
                } else{
                    Helper.showMsg("error");
                }
            }
            loadUserModel();
        });

        tbl_userList.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_user_id = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString();
                txt_id.setText(select_user_id);
            } catch (Exception exception) {
                exception.getMessage();
            }

            //PatikaList
            patikamenu = new JPopupMenu();
            JMenuItem updateMenu = new JMenuItem("Güncelle");
            JMenuItem deleteMenu = new JMenuItem("Sil");
            patikamenu.add(updateMenu);
            patikamenu.add(deleteMenu);

            updateMenu.addActionListener(a -> {
                int select_id = Integer.parseInt(tbl_patikalist.getValueAt(tbl_patikalist.getSelectedRow(), 0).toString());
                UpdatePatikaGUI updatePatikaGUI = new UpdatePatikaGUI(Patika.getFetch(select_id));
                updatePatikaGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadPatikaModel();
                    }
                });
            });

            deleteMenu.addActionListener( a ->{
                if(Helper.confirm("sure")){
                    int select_id = Integer.parseInt(tbl_patikalist.getValueAt(tbl_patikalist.getSelectedRow(), 0).toString());
                    if(Patika.delete(select_id)){
                        Helper.showMsg("done");
                        loadPatikaModel();
                    } else{
                        Helper.showMsg("error");
                    }
                }
            });

            mdl_patikalist = new DefaultTableModel();
            Object[] col_patikalist = {"ID", "Patika Adı"};
            mdl_patikalist.setColumnIdentifiers(col_patikalist);
            row_patikalist  =new Object[col_patikalist.length];
            loadPatikaModel();

            tbl_patikalist.setModel(mdl_patikalist);
            tbl_patikalist.setComponentPopupMenu(patikamenu);
            tbl_patikalist.getTableHeader().setReorderingAllowed(false);
            tbl_patikalist.getColumnModel().getColumn(0).setMaxWidth(75);

            tbl_patikalist.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point point = e.getPoint();
                    int selectedRow = tbl_patikalist.rowAtPoint(point);
                    tbl_patikalist.setRowSelectionInterval(selectedRow,selectedRow);
                }
            });
            //##PatikaList

            //CourseList
            mdl_course_list = new DefaultTableModel();
            Object[] col_courselist = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
            mdl_course_list.setColumnIdentifiers(col_courselist);
            row_courseList = new Object[col_courselist.length];
            loadCourseList();

            tbl_course_list.setModel(mdl_course_list);
            tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
            tbl_course_list.getTableHeader().setReorderingAllowed(false);

            Item item = new Item(1,"Ahmet yılmaz");
            fld_patika.setText(item.getValue());
            //##CourseList
            btn_add.addActionListener(a -> {
                if (Helper.isFieldEmpty(fld_user_names) || Helper.isFieldEmpty(fld_name) || Helper.isFieldEmpty(fld_password) || Helper.isFieldEmpty(fld_type)) {
                    Helper.showMsg("fill");
                } else {
                    String name = fld_name.getText();
                    String username = fld_user_names.getText();
                    String password = fld_password.getText();
                    String type = fld_type.getText();
                    if (User.add(name, username, password, type)) {
                        Helper.showMsg("success");
                        loadUserModel();
                        fld_name.setText(null);
                        fld_user_names.setText(null);
                        fld_password.setText(null);
                    } else {
                        Helper.showMsg("error");
                    }
                }
            });
            btn_user_delete.addActionListener(a -> {
                    if (Helper.isFieldEmpty(txt_id)) {
                        Helper.showMsg("fill");
                    } else {
                        if (Helper.confirm("sure")) {
                            int user_id = Integer.parseInt(txt_id.getText());
                            if(User.delete(user_id)) {
                                Helper.showMsg("done");
                                loadUserModel();
                            }
                            else {
                                Helper.showMsg("error");
                            }
                        }
                    }
            });
        });
        btn_search.addActionListener( e -> {
            String name = fld_name.getText();
            String username = fld_user_names.getText();
            String type = fld_type.getText();
            String query = User.searchquery(name,username,type);
            ArrayList<User> searchingUser = User.searchUserList(query);
            loadUserModel(User.searchUserList(query));
        });
        btn_cikis.addActionListener(e -> {
            dispose();
        });
        ekleButton.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_patikaname)){
                Helper.showMsg("fill");
            } else{
                if(Patika.add(fld_patikaname.getText())){
                    Helper.showMsg("done");
                    loadPatikaModel();
                    fld_patikaname.setText(null);
                } else{
                    Helper.showMsg("error");
                }
            }
        });
    }

    private void loadCourseList() {
        DefaultTableModel model = (DefaultTableModel) tbl_course_list.getModel();
        model.setRowCount(0);
        int i = 0;
        for(Course course: Course.getList()){
            i=0;
            row_courseList[i++]=course.getId();
            row_courseList[i++]=course.getName();
            row_courseList[i++]=course.getLang();
            row_courseList[i++]=course.getPatika().getName();
            row_courseList[i++]=course.getEducator().getName();
            mdl_course_list.addRow(row_courseList);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patikalist.getModel();
        clearModel.setRowCount(0);
        int i  = 0;
        for (Patika obj: Patika.getList()){
            row_patikalist[i++] = obj.getId();
            row_patikalist[i++] = obj.getName();
            mdl_patikalist.addRow((row_patikalist));
        }
    }

    public void loadUserModel() {
            DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
            clearModel.setRowCount(0);

            for (User user : User.getList()) {
                int i = 0;
                row_User_List[i++] = user.getId();
                row_User_List[i++] = user.getName();
                row_User_List[i++] = user.getUsername();
                row_User_List[i++] = user.getPassword();
                row_User_List[i++] = user.getType();
                mdl_user_list.addRow(row_User_List);
            }
    }

    public void loadUserModel(ArrayList<User> list) {
            DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
            clearModel.setRowCount(0);

            for (User user : User.getList()) {
                int i = 0;
                row_User_List[i++] = user.getId();
                row_User_List[i++] = user.getName();
                row_User_List[i++] = user.getUsername();
                row_User_List[i++] = user.getPassword();
                row_User_List[i++] = user.getType();
                mdl_user_list.addRow(row_User_List);
            }
    }


    public static void main(String[] args) {
        Operator operator1 = new Operator();
        operator1.setId(1);
        operator1.setName("Umur E. Uysal");
        operator1.setPassword("1234");
        operator1.setUsername("ueuysal");
        operator1.setType("Operator");


        OperatorGUI gui = new OperatorGUI(operator1);
    }
}
