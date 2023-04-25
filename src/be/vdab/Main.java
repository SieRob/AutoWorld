package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import com.sun.source.tree.Tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        var persoonwagen1 = new Personenwagen("Renault",2_355,3);
        var persoonwagen2 = new Personenwagen("Opel",4_499,4);
        var persoonwagen3 = new Personenwagen("Mercedes",7_890);

        var pickup1=new Pickup("Dodge",9_452,3,
                new Volume(30,10,60, Maat.DECIMETER));
        var pickup2=new Pickup("Ford",9_452,
               new Volume(40,20,30, Maat.DECIMETER));
        var pickup3=new Pickup();

        var vrachtwagen1=new Vrachtwagen("Volvo", 15_699,
                new Volume(6,6,16, Maat.METER),
                20_000, 8);
        var vrachtwagen2=new Vrachtwagen("Scania", 15_699,
                new Volume(5,4,10, Maat.METER),
                15_000, 6);

        //SortedSet van voertuigen: -> done
        // 2 persoonwagens, 2 pickups, 2 vrachtwagens
        var voertuigSet = new TreeSet<Voertuig>();
        voertuigSet.add(persoonwagen1);
        voertuigSet.add(persoonwagen2);
        voertuigSet.add(persoonwagen3);
        voertuigSet.add(pickup1);
        voertuigSet.add(pickup2);
        voertuigSet.add(pickup3);
        voertuigSet.add(vrachtwagen1);
        voertuigSet.add(vrachtwagen2);

        voertuigSet.forEach(entry -> System.out.println(entry));
        System.out.println("----");


        //Bewaar in bestand wagenpark.dat -> done
        //var path = Path.of("E:/VDAB/JPF17_Theoriemateriaal/data/wagenpark.dat"); //Personal exisiting path
        var path = Path.of("/data/wagenpark.dat"); //Path defined in task

        try (var writer = new ObjectOutputStream(Files.newOutputStream(path))){
            writer.writeObject(voertuigSet);
        }catch (IOException e){
            System.out.println(e);
        }

        //Lees wagenpark.dat, geef sortedSet terug en toon -> Done
        try (var reader = new ObjectInputStream(Files.newInputStream(path))){
            var data = (TreeSet<Voertuig>) reader.readObject();
            System.out.println(data);
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        System.out.println("----");

        //Maak boekentas objecten aan en toon -> done
        var boekentas1 = new Boekentas("Rood", new Volume(28, 31, 12, Maat.CENTIMETER));
        var boekentas2 = new Boekentas("Blauw", new Volume(31, 26, 11, Maat.CENTIMETER));
        var boekentas3 = new Boekentas("Groen", new Volume(30, 28, 12, Maat.CENTIMETER));

        System.out.println(boekentas1);
        System.out.println(boekentas2);
        System.out.println(boekentas3);
        System.out.println("----");

        //Maar array van interface Laadbaar -> done
        var laad = new ArrayList<Laadbaar>();
        var totaleLaadVolume = 0D;
        laad.add(boekentas1);
        laad.add(boekentas2);
        laad.add(vrachtwagen2);
        laad.add(pickup1);
        laad.add(boekentas3);

        //vul met voertuigen en boekentassen & toon -> done

        //toon totale laadvolume -> done
        for(var entry : laad){
            totaleLaadVolume += entry.getLaadVolume().getVolume();
        }

        System.out.println("Totale laad volume (For loop): " + totaleLaadVolume + "m³");

        System.out.println("Totale laad volume (lambda): " + laad.stream().mapToDouble(entry-> entry.getLaadVolume().getVolume()).sum()+ "m³");


    }
}
