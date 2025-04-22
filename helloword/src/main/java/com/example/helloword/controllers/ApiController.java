package com.example.helloword.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.helloword.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ApiController {
   // http://localhost:8080
    @GetMapping("/")
    public String home() {
        return "Home de campers!";
    }

    @GetMapping("/saludo")// http://localhost:8080/saludo?nombre=zully o http://localhost:8080/saludo?nombre=zully&apellido=Ortiz

    public String saludo(
        @RequestParam(name= "nombre", required = true)String name,
        @RequestParam(name = "apellido", required = false, defaultValue = "Apellido comun")String lastname) {
        return "Hello " + name + " " + lastname;
    }

    @GetMapping("/search") //http://localhost:8080/search
    public Map<String, String> buscar(
         @RequestParam(name = "name", defaultValue = "Apellido comun")String name) {
            Map<String, String> cities = new HashMap<>();
            cities.put( "BUC", "Bucaramanga");
            cities.put( "NYC", "New York");
            cities.put( "BOG", "Bogota");
            cities.put( "NVA", "Neiva");
            cities.put( "LET", "Leticia");
            cities.put( "PER", "Pereira");

            // Devuelva una ciudad en especifico 
            // http://localhost:8080/search?name=co SI NO ESTA LA CIUDAD SE MOSTRARA TODAS LAS CIUDADES
            // http://localhost:8080/search?name=BUC Filtra solo la ciudad bucaramanga
            if(cities.containsKey(name)){
                return Map.of(name,cities.get(name) );// Pasar de string a Map
            }else{
                return cities;
            }
    }


    @GetMapping("/tax") //http://localhost:8080/tax
    public Map<String, Object>calcular(
        @RequestParam(name = "impuesto", defaultValue = "0") double impuestos
        ) {
            List<Producto> productos = new ArrayList<>(
                List.of(new Producto(1, "Pan", 2000))
                );
            productos.add(new Producto(2, "Gaseosa", 3500));
            productos.add(new Producto(3, "Salchichon Zenu", 1500));
                double total = 0;
                for (Producto p : productos){
                    total += p.getPrice();
                }
                double total_impuesto;
                if(impuestos > 0){
                    impuestos = impuestos / 100;
                    total_impuesto = impuestos * total + total;  
                }else{
                    total_impuesto = 0;
                }

                // stream es un objeto para manipular lo que seria listas 
                // identity el valor acumulado de una funcion 
                // modificar o alterar la estructura 
                double precios = productos.stream().map(producto -> producto.getPrice()).reduce(0.0, (precioA, precioB) -> precioA + precioB);
            
            //return Map.of("productos", productos, "total", total_impuesto, "valor_neto", total);

            return Map.of("productos", productos, "total", (precios + (precios * impuestos/100)) , "valor_neto", precios, "iva: ", impuestos + "%");

    }
}
