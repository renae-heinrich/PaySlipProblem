//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
//public class incomeTaxCalculator {
//
//        public static void main(String[] args) {
//
//            taxBreakPoints(65050);
//        }
//
//        public static void taxBreakPoints(double annualSalary) {
//            BigDecimal incomeTax;
//            if (annualSalary >= 0 && annualSalary <= 18200) {
//                incomeTax = new BigDecimal(0);
//            } else if (annualSalary >= 18201 && annualSalary <= 37000) {
//                incomeTax = BigDecimal.valueOf(((annualSalary - 18200) * 0.19) / 12).setScale(0, RoundingMode.HALF_UP);
//                System.out.println("Income Tax: " + incomeTax);
//            } else if (annualSalary >= 37001 && annualSalary <= 87000) {
//                incomeTax = BigDecimal.valueOf((3572 + ((annualSalary - 37000) * 0.325)) / 12).setScale(0, RoundingMode.HALF_UP);
//                System.out.println("Income Tax: " + incomeTax);
//            } else if (annualSalary >= 87001 && annualSalary <= 180000) {
//                incomeTax = BigDecimal.valueOf((19822 + ((annualSalary - 87000) * 0.37)) / 12).setScale(0, RoundingMode.HALF_UP);
//                System.out.println("Income Tax " + incomeTax);
//            } else {
//                incomeTax = BigDecimal.valueOf((54232 + ((annualSalary - 180000) * 0.45)) / 12).setScale(0, RoundingMode.HALF_UP);
//                System.out.println("Income Tax " + incomeTax);
//            }
//        }
//    }




//    private Integer num;
//
//    public incomeTaxCalculator(Integer num) {
//        this.num = num;
//    }
//
//    public Integer classFcuntion() {
//        this.num
//        return 2;
//    }
//
//    public static Integer staticFn() {
//        return 5;
//    }