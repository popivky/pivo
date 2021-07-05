public class Hospital {

    final static float MIN_HEALTH_TEMPERATURE = (float) 36.2;
    final static float MAX_HEALTH_TEMPERATURE = (float) 36.9;
    final static float MIN_TEMPERATURE = (float) 32;
    final static float MAX_TEMPERATURE = (float) 40;




    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        float[] temperatureData = new float[patientsCount];


        for ( int i = 0; i < temperatureData.length; i++) {

            temperatureData[i] = (float) (Math.round(((Math.random()*((MAX_TEMPERATURE-MIN_TEMPERATURE)))+MIN_TEMPERATURE)*10)/10.0);

        }

        return new float[patientsCount];
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
              */

        float average;
        float sum = 0;
        int health = 0;
        StringBuilder list = new StringBuilder();


        for (float temperatureDatum : temperatureData) {
            list.append(temperatureDatum).append(" ");
            sum += temperatureDatum;
            if (temperatureDatum >= MIN_HEALTH_TEMPERATURE && temperatureDatum <= MAX_HEALTH_TEMPERATURE) {
                health++;
            }
        }
        average = (float) (Math.round(((sum / temperatureData.length) * 100)) / 100.0);



        String report =
                "Температуры пациентов: " + list.toString().trim() +
                        "\nСредняя температура: " + average +
                        "\nКоличество здоровых: " + health;

        return report;
    }
}
