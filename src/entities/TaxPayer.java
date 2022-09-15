package entities;

public class TaxPayer {

	// Attributes

	double salaryIncome;
	double servicesIncome;
	double capitalIncome;

	double healthSpending;
	double educationSpending;

	// Constructors and Getters/Setter

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {

		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	// Methods

	public double salaryTax() {

		double monthlyIncome = salaryIncome / 12.00;

		if (monthlyIncome < 3000.00f) {
			return 0f;
		} else if (monthlyIncome < 5000.00f) {
			return 0.1f * salaryIncome;
		} else {
			return 0.2f * salaryIncome;
		}

	}

	public double servicesTax() {
		return 0.15 * servicesIncome;
	}

	public double capitalTax() {
		return 0.20 * capitalIncome;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maxRebate = grossTax() * 0.30;
		double spending = healthSpending + educationSpending;

		if (spending > maxRebate) {
			return maxRebate;
		} else {
			return spending;
		}

	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

}
