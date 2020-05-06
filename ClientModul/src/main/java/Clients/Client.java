package Clients;

import Modules.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {

    private static Humidity getLatestHumidity() {
        final String url = "http://localhost:8080/getLatestHumidity";
        RestTemplate restTemplate = new RestTemplate();
        Humidity result = restTemplate.getForObject(url,Humidity.class);
        return result;
    }
    private static Temperature getLatestTemperature() {
        final String url = "http://localhost:8080/getLatestTemperature";
        RestTemplate restTemplate = new RestTemplate();
        Temperature result = restTemplate.getForObject(url,Temperature.class);
        return result;
    }
    private static Illumination getLatestIllumination() {
        final String url = "http://localhost:8080/getLatestIllumination";
        RestTemplate restTemplate = new RestTemplate();
        Illumination result = restTemplate.getForObject(url,Illumination.class);
        return result;
    }
    private static Electricity getLatestElectricity() {
        final String url = "http://localhost:8080/getLatestElectricity";
        RestTemplate restTemplate = new RestTemplate();
        Electricity result = restTemplate.getForObject(url,Electricity.class);
        return result;
    }

    private static Humidity setHumidity(int id,int humidity) {
        final String url = "http://localhost:8080/updateHumidity?id={id}&humidity={humidity}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        params.put("humidity",humidity);
        RestTemplate restTemplate = new RestTemplate();
        Humidity result = restTemplate.getForObject(url,Humidity.class,params);
        return result;
    }

    private static Temperature setTemperature(int id,int temperature) {
        final String url = "http://localhost:8080/updateTemperature?id={id}&temperature={temperature}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        params.put("temperature",temperature);
        RestTemplate restTemplate = new RestTemplate();
        Temperature result = restTemplate.getForObject(url,Temperature.class,params);
        return result;
    }
    private static Illumination setIllumination(int id,int illumination) {
        final String url = "http://localhost:8080/updateLightning?id={id}&illumination={illumination}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("id",id);
        params.put("illumination",illumination);
        RestTemplate restTemplate = new RestTemplate();
        Illumination result = restTemplate.getForObject(url,Illumination.class,params);
        return result;
    }

    private static Report getReport() {
        final String url = "http://localhost:8080/gethumiTempIlluReport";
        RestTemplate restTemplate = new RestTemplate();
        Report result = restTemplate.getForObject(url,Report.class);
        return result;
    }

    private static WeeklyReport getWeeklyHumidityReport() {
        final String url = "http://localhost:8080/getWeekHumidity";
        RestTemplate restTemplate = new RestTemplate();
        WeeklyReport result = restTemplate.getForObject(url,WeeklyReport.class);
        return result;
    }

    private static WeeklyReport getWeeklyTemperatureReport() {
        final String url = "http://localhost:8080/getWeekTemperature";
        RestTemplate restTemplate = new RestTemplate();
        WeeklyReport result = restTemplate.getForObject(url,WeeklyReport.class);
        return result;
    }
    private static WeeklyReport getWeeklyIlluminationReport() {
        final String url = "http://localhost:8080/getWeekIllumination";
        RestTemplate restTemplate = new RestTemplate();
        WeeklyReport result = restTemplate.getForObject(url,WeeklyReport.class);
        return result;
    }
    private static int getElectricityConsumptionCost(int Cost) {
        final String url = "http://localhost:8080/getWeeklyElectricityCost?Cost={Cost}";
        Map<String ,Integer> params = new HashMap<>();
        params.put("Cost",Cost);
        RestTemplate restTemplate = new RestTemplate();
        int result = restTemplate.getForObject(url,int.class,params);
        return result;
    }


    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("1: Read latest humidity.\n2: Read latest temperature\n3: Read latest illumination\n" +
                    "4: Read latest electricity\n5: Set humidity value\n6: Set temperature value\n7: Set illumination value\n8: Get latest humidity,temperature,illumination report." +
                    "\n9: Get humidity weekly report with avrage.\n10:Get temperature weekly report with avrage.\n11:Get illumination weekly report with avrage.\n12:Count electricity consumption cost.");
            int choice,friendId;
            choice= scanner.nextInt();
            switch (choice)
            {
                case 1: {
                    Humidity humidity = new Humidity();
                     humidity = getLatestHumidity();
                    System.out.println("Id: "+humidity.getId()+"\nDate: "+humidity.getDate()+"\nHumidity:"+humidity.getHumidity());
                    break;
                }
                case 2: {
                    Temperature temperature = new Temperature();
                    temperature = getLatestTemperature();
                    System.out.println("Id: "+temperature.getId()+"\nDate: "+temperature.getDate()+"\nTemperature:"+temperature.getTemperature());
                    break;
                }
                case 3: {
                    Illumination illumination = new Illumination();
                    illumination = getLatestIllumination();
                    System.out.println("Id: "+illumination.getId()+"\nDate: "+illumination.getDate()+"\nIllumination:"+illumination.getIllumination());
                    break;
                }
                case 4: {
                    Electricity electricity = new Electricity();
                    electricity = getLatestElectricity();
                    System.out.println("Id: "+electricity.getId()+"\nDate: "+electricity.getDate()+"\nElectricity:"+electricity.getElectricity());
                    break;
                }
                case 5: {
                    Humidity humidity = new Humidity();
                    humidity = setHumidity(1,11);
                    break;
                }
                case 6: {
                    Temperature temperature = new Temperature();
                    temperature = setTemperature(1,10);
                    break;
                }
                case 7: {
                    Illumination illumination = new Illumination();
                    illumination = setIllumination(1,75);
                    break;
                }
                case 8: {
                    Report report = new Report();
                    report = getReport();
                    System.out.println("Date: "+report.getDate()+"\nHumidity: "+report.getHumidity()+"\nTemperature: "+report.getTemperature()+"\nIllumination:"+report.getIllumination());
                    break;
                }
                case 9: {
                    WeeklyReport report = new WeeklyReport();
                    report = getWeeklyHumidityReport();
                    System.out.println("Date: "+report.getDate()+"\nHumidity: "+report.getMap()+"\nAvrage: "+report.getAvrage());
                    break;
                }
                case 10: {
                    WeeklyReport report = new WeeklyReport();
                    report = getWeeklyTemperatureReport();
                    System.out.println("Date: "+report.getDate()+"\nTemperature: "+report.getMap()+"\nAvrage: "+report.getAvrage());
                    break;
                }
                case 11: {
                    WeeklyReport report = new WeeklyReport();
                    report = getWeeklyIlluminationReport();
                    System.out.println("Date: "+report.getDate()+"\nIllumination: "+report.getMap()+"\nAvrage: "+report.getAvrage());
                    break;
                }
                case 12: {
                    int cost = getElectricityConsumptionCost(2);
                    System.out.println("Electricity Consumption Cost: "+cost);
                    break;
                }
            }
            Thread.sleep(1000);
        }
    }
}

