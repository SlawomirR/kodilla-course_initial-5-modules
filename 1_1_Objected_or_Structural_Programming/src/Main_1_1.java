public class Main_1_1 {
        // switch debug information ON or OFF
        private static boolean DEBUG = false;

        // static method for debug purposes; all instances in code are marked => // DEBUG
        public static void debugInfo(String message) {
            if (DEBUG == true) {
                System.out.println("DEBUG: " + message);
            }
        }

        public static void main(String[] args) throws java.lang.Exception {
            // creating an object for access to methods from the UserValidator class
            UserValidator validate = new UserValidator();

            // preliminary data of the task
            String name = "Adam";
            double age = 40.5;
            double height = 178;

            // unimportant info to show in console
            System.out.println("INFO: Preliminary data of the task:");
            System.out.println("INFO: User name: " + name + ", age: " + age + ", height: " + height + ".\n");

            // main executive block for the task
            if (validate.validateName(name)) {
                debugInfo("After name checking"); // DEBUG
                System.out.print(validate.validateAge(age));
                System.out.println(validate.validateHeight(height));

                System.out.println("\nINFO: The program has finished functioning correctly");
            } else {
                System.err.println("ERROR: There is no (user) \"name\" value!");
            }
        }
    }
    class UserValidator {
        // constants defining the division of data ranges
        public static final double AGE_CHANGING_POINT = 30;
        public static final double HEIGHT_CHANGING_POINT = 160;

        public boolean validateName(String name) {
            boolean result;
            if (name != null) {
                Main_1_1.debugInfo("name is true"); // DEBUG
                result = true;
            } else {
                Main_1_1.debugInfo("name is false"); // DEBUG
                result = false;
            }
            return result;
        }

        // checking the range for age
        public String validateAge(double age) {
            Main_1_1.debugInfo("age statement 0"); // DEBUG
            if ((age <= 0) || (age > 130)) {
                Main_1_1.debugInfo("age statement 1"); // DEBUG
                return "WARNING: Unusual case - check age value";
            } else {
                if (age > 30) {
                    Main_1_1.debugInfo("age statement 2"); // DEBUG
                    return "User is older than " + AGE_CHANGING_POINT;
                } else {
                    Main_1_1.debugInfo("age statement 3"); // DEBUG
                    return "User is younger (or equal) than " + AGE_CHANGING_POINT;
                }
            }
        }

        // checking the range for growth
        public String validateHeight(double height) {
            if ((height <= 0) || (height > 275)) {
                return "WARNING: Unusual case - check height value";
            } else {
                if (height > 160) {
                    return " and higher than " + HEIGHT_CHANGING_POINT + "cm.";
                } else {
                    return " or lower (or equal) than " + HEIGHT_CHANGING_POINT + "cm.";
                }
            }
        }
    }
