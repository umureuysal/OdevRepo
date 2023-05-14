import java.time.Year;

public class Employee {
    String name;

    double salary;
    int workhours;
    int hireYear;


    public Employee(String name, double salary, int workhours, int hireYear) {
        this.name=name;
        this.salary=salary;
        this.workhours=workhours;
        this.hireYear = hireYear;
    }

    void tax(){
        double tax;
        if(salary<1000) {
            tax = 0;
        }
        else{
            tax=salary/100*3;
        }
        System.out.println("Vergi: "+ tax);
    }

    void bonus()
    {
        double bonus=0;
        if(this.workhours>40){
             bonus = (workhours-40)*30;
        }
        System.out.println("Bonus: " + bonus);
    }

    void raiseSalary(){
        double raise;
        if(2021-this.hireYear<10)
            raise=this.salary*15/100;
        else if (2021-this.hireYear>=10&&2021-this.hireYear<20)
            raise=this.salary*10/100;
        else
            raise=this.salary*15/100;
        System.out.println("Zam: "+raise);
    }

    public void ToString(){
        System.out.println("Adı: " + this.name);
        System.out.println("Maaşı: " + this.salary);
        System.out.println("Çalışma saati: " + this.workhours);
        System.out.println("Başlangıç Yılı: " + this.hireYear);
        this.tax();
        this.bonus();
        this.raiseSalary();
    }
}
