package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class CarDatabase {

    private HashMap<String, Vehicle> CarDataBase = new HashMap();
    private model.MagicGenerator generator = new model.MagicGenerator();

    CarDatabase()
    {
        for (int i = 0; i < 100; i++)
        {
            String manufacturer = generator.getRandomManufacturer();
            String licencePlate = generator.getRandomLicencePlate();

            Vehicle vehicle = new Vehicle(generator.getRandomColor(),
                    generator.getRandomName(), manufacturer,
                    generator.getRandomModel(manufacturer),
                    licencePlate);

            CarDataBase.put(licencePlate, vehicle);
        }
    }

    public ArrayList<Vehicle> search(String licencePlate, boolean exact)
    {
        ArrayList<Vehicle> cars = new ArrayList();
        if (exact)
        {
            try
            {
                cars.add(CarDataBase.get(licencePlate));
            }
            catch (Exception x){ }
        }

        else
            {
            for (String key: CarDataBase.keySet())
            {
                if (key.contains(licencePlate))
                {
                    cars.add(CarDataBase.get(key));
                }
            }
        }
        return cars;
    }
}