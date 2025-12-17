        interface Engine {
            void start();
        }

        interface Radio {
            void playMusic();
        }

        class GasEngine implements Engine {
            public void start() {
                System.out.println("Gas engine started");
            }
        }

        class ElectricEngine implements Engine {
            public void start() {
                System.out.println("Electric engine started");
            }
        }

        class Car {
            private Engine engine;

            public Car(Engine engine) {
                this.engine = engine;
            }

            public void drive() {
                engine.start();
            }
        }

        class SportsCar extends Car {
            public SportsCar(Engine engine) {
                super(engine);
            }

            void driveFast() {
                System.out.println("Driving fast");
            }
        }


        public class Main {
            public static void main(String[] args) {
                Engine gas = new GasEngine();
                Engine electric = new ElectricEngine();

                Car car1 = new Car(gas);
                Car car2 = new Car(electric);
                Car sportsCar = new SportsCar(gas);

                car1.drive();
                car2.drive();
                sportsCar.drive();

            }
        }