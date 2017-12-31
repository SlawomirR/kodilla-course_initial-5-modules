/*
Zadanie: Tworzenie obiektów z wykorzystaniem klasy abstrakcyjnej

Wykorzystując poniższy kod:

interface Employee {
	double calculateSalary();
}

class FixedSalaryEmployee implements Employee {
	private double salary;
	public FixedSalaryEmployee(double salary) {
		this.salary = salary;
	}
	public double calculateSalary() {
		return this.salary;
	}
}

class HourlySalaryEmployee implements Employee {
	private double hours;
	private double hourlyPay;
	public HourlySalaryEmployee(double hours, double hourlyPay) {
		this.hours = hours;
		this.hourlyPay = hourlyPay;
	}
	public double calculateSalary() {
		return this.hourlyPay * this.hours;
	}
}

// Payout
abstract class SalaryPayout {
	private Employee employee;
	public SalaryPayout(Employee employee) {
		this.employee = employee;
	}
	protected abstract void payout();
	public void processPayout() {
		System.out.println("Creating payout for: " + this.employee.calculateSalary() + " PLN");
		this.payout();
		System.out.println("Payout has been completed!");
	}
}

class SalaryPayoutProcessor extends SalaryPayout {
	public SalaryPayoutProcessor(Employee employee) {
		super(employee);
	}
	protected void payout() {
		System.out.println("Sending money to employee");
	}
}

class Application {
	public static void main(String args[]) {
		FixedSalaryEmployee employee = new FixedSalaryEmployee(2000);
		HourlySalaryEmployee employee1 = new HourlySalaryEmployee(40, 19);
		SalaryPayoutProcessor processor = new SalaryPayoutProcessor(employee1);
		processor.processPayout();
	}
}

utwórz nowe obiekty pracowników:

    Pracownika zarabiającego 5 zł za stworzenie jednego produktu,
    Pracownika, który zarabia pensję podstawową 2000zł i 20% tej pensji jeżeli zrealizuje dodatkową sprzedaż dowolnego produktu

Podpowiedź: w tym zadaniu będziesz tworzyć tylko obiekty na podstawie podanego kodu, który używa klas abstrakcyjnych.
Nie musisz tworzyć nowych klas abstrakcyjnych.
*/
public class Main_1_5 {
    public static void main(String[] args) {
        // 1. Pracownika zarabiającego 5 zł za stworzenie jednego produktu,
        int numberOfProducts = 250;
        double unitPrice = 5;
        FixedSalaryPerProduct employee2 = new FixedSalaryPerProduct(numberOfProducts, unitPrice);
        SalaryPayoutProcessor processor2 = new SalaryPayoutProcessor(employee2);
        processor2.processPayout();

        // 2. Pracownika, który zarabia pensję podstawową 2000zł i 20% tej pensji jeżeli zrealizuje dodatkową sprzedaż dowolnego produktu.
        double basicSalary = 2000;
        double percentOfProfit = 0.2;
        BonusSalaryPerProduct employee3 = new BonusSalaryPerProduct(basicSalary, percentOfProfit);
        SalaryPayoutProcessor processor3 = new SalaryPayoutProcessor(employee3);
        processor3.processPayout();

        /* z wzorcowego zadania
        FixedSalaryEmployee employee = new FixedSalaryEmployee(2000);
        SalaryPayoutProcessor processor = new SalaryPayoutProcessor(employee);
        processor.processPayout();

        HourlySalaryEmployee employee1 = new HourlySalaryEmployee(40, 19);
        SalaryPayoutProcessor processor1 = new SalaryPayoutProcessor(employee1);
        processor1.processPayout();
        */
    }
}
interface Employee {
    double calculateSalary();
}

// 1. Pracownika zarabiającego 5 zł za stworzenie jednego produktu,
class FixedSalaryPerProduct implements Employee {
    private int numberOfProducts;
    private double unitPrice;

    FixedSalaryPerProduct(int numberOfProducts, double unitPrice) {
        this.numberOfProducts = numberOfProducts;
        this.unitPrice = unitPrice;
    }

    @Override
    public double calculateSalary() {
        return numberOfProducts * unitPrice;
    }
}

// 2. Pracownika, który zarabia pensję podstawową 2000zł i 20% tej pensji jeżeli zrealizuje dodatkową sprzedaż dowolnego produktu.
class BonusSalaryPerProduct implements Employee {
    private double basicSalary;
    private double percentOfProfit;

    BonusSalaryPerProduct(double basicSalary, double percentOfProfit) {
        this.basicSalary = basicSalary;
        this.percentOfProfit = percentOfProfit;
    }

    @Override
    public double calculateSalary() {
        return (basicSalary) + (basicSalary * percentOfProfit);
    }
}

// Payout
abstract class SalaryPayout {
    private Employee employee;

    SalaryPayout(Employee employee) {
        this.employee = employee;
    }

    protected abstract void payout();

    public void processPayout() {
        System.out.println("Creating payout for: " + this.employee.calculateSalary() + " PLN");
        this.payout();
        System.out.println("Payout has been completed!");
        System.out.println("==========================");
    }
}

class SalaryPayoutProcessor extends SalaryPayout {
    SalaryPayoutProcessor(Employee employee) {
        super(employee);
    }

    protected void payout() {
        System.out.println("Sending money to employee");
    }
}

/* z wzorcowego zadania
class FixedSalaryEmployee implements Employee {
    private double salary;

    public FixedSalaryEmployee(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        return this.salary;
    }
}

class HourlySalaryEmployee implements Employee {
    private double hours;
    private double hourlyPay;

    public HourlySalaryEmployee(double hours, double hourlyPay) {
        this.hours = hours;
        this.hourlyPay = hourlyPay;
    }

    public double calculateSalary() {
        return this.hourlyPay * this.hours;
    }
}
*/