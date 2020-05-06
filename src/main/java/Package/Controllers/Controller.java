package Package.Controllers;

import Package.Util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Hello milkon";
    }

    @RequestMapping(value ="/getLatestHumidity",headers = "Accept=application/json")
    public Humidity getLatestHumidity() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getlastHumidity();
    }
    @RequestMapping(value ="/getLatestTemperature",headers = "Accept=application/json")
    public Temperature getLatestTemperature() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getlastTemperature();
    }
    @RequestMapping(value ="/getLatestIllumination",headers = "Accept=application/json")
    public Illumination getLatestIllumination() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getlastIllumination();
    }
    @RequestMapping(value ="/getLatestElectricity",headers = "Accept=application/json")
    public Electricity getLatestElectricity() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getlastElectricity();
    }
    @RequestMapping(value ="/updateHumidity",headers = "Accept=application/json")
    public Humidity updateHumidity(@RequestParam int id,float humidity ) throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.updateHumidity(id,humidity);
    }

    @RequestMapping(value ="/updateTemperature",headers = "Accept=application/json")
    public Temperature updateTemperature(@RequestParam int id,float temperature ) throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.updateTemperature(id,temperature);
    }

    @RequestMapping(value ="/updateLightning",headers = "Accept=application/json")
    public Illumination updateElectricity(@RequestParam int id,int illumination ) throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.updateIllumination(id,illumination);
    }

    @RequestMapping(value ="/gethumiTempIlluReport",headers = "Accept=application/json")
    public Report gethumiTempIlluReport() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.humiTempIlluReport();
    }

    @RequestMapping(value ="/getWeekHumidity",headers = "Accept=application/json")
    public WeeklyReport getWeekHumidity() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getWeekHumidity();
    }

    @RequestMapping(value ="/getWeekTemperature",headers = "Accept=application/json")
    public WeeklyReport getWeekTemperature() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getWeekTemperature();
    }

    @RequestMapping(value ="/getWeekIllumination",headers = "Accept=application/json")
    public WeeklyReport getWeekIllumination() throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getWeekIllumination();
    }

    @RequestMapping(value ="/getWeeklyElectricityCost",headers = "Accept=application/json")
    public int getWeeklyElectricityCost(@RequestParam int Cost  ) throws IOException, ClassNotFoundException {
        SQLdbDao dataBase = new SQLdbDao();
        return dataBase.getElectricityCost() * Cost;
    }
}
