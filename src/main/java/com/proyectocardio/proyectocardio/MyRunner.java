package com.proyectocardio.proyectocardio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Diploma;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.repositories.AlumnoRepository;
import com.proyectocardio.proyectocardio.repositories.ClienteRepository;
import com.proyectocardio.proyectocardio.repositories.CursoRepository;
import com.proyectocardio.proyectocardio.repositories.DiplomaRepository;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;
import com.proyectocardio.proyectocardio.repositories.EspacioRepository;
import com.proyectocardio.proyectocardio.repositories.FormacionRepository;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;
import com.proyectocardio.proyectocardio.repositories.VehiculoRepository;



//Haciendo que la clase sea ejecutable
@Component
public class MyRunner  implements CommandLineRunner{

   //Preparando log para recibir informacion
    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    
    //Declaracion de  repositorios
    private final AlumnoRepository alumnoRepositorio;
    private final EquipoRepository equipoRepositorio;
    private final CursoRepository cursoRepositorio;
    private final ClienteRepository clienteRepositorio;
    private final DiplomaRepository diplomaRepositorio;
    private final FormacionRepository formacionRepositorio; 
    private final VehiculoRepository vehiculoRepositorio;
    private final LugarRepository lugarRepositorio;
    private final EspacioRepository espacioRepositorio;


    //Inyeccion de repositorios en constructor
    public MyRunner(AlumnoRepository alumnoRepositorio,EquipoRepository equipoRepositorio,CursoRepository cursoRepositorio,ClienteRepository clienteRepositorio,
                    DiplomaRepository diplomaRepositorio,FormacionRepository formacionRepositorio,VehiculoRepository vehiculoRepositorio,
                    LugarRepository lugarRepositorio,EspacioRepository espacioRepositorio) {
        this.alumnoRepositorio=alumnoRepositorio;
        this.equipoRepositorio=equipoRepositorio;
        this.cursoRepositorio=cursoRepositorio;
        this.clienteRepositorio=clienteRepositorio;
        this.diplomaRepositorio=diplomaRepositorio;
        this.formacionRepositorio=formacionRepositorio; 
        this.vehiculoRepositorio=vehiculoRepositorio;
        this.lugarRepositorio=lugarRepositorio;
        this.espacioRepositorio=espacioRepositorio;
      }

    //@Transactional 
    @Override
    public void run(String... args) throws Exception {
       
        //Persistencia de equipos
        Equipo equipo1=new Equipo();
        equipo1.setNumSerie("12221111");
        equipo1.setMarca("Vital");
        equipo1.setModelo("Antiguo");
        equipo1.setFabricante("Samsung");
        equipo1.setOperador("Vodafone");
        equipo1.setPin("123456");
        equipo1.setPuk("0203");
        equipo1.setCodAiviago("8823");
        equipo1.setNumtlfnoAiviago("875663231");
        equipo1.setRefCabina("A07");
        equipo1.setNumSerieCabina("112233");
        LocalDate fechFab = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
        LocalDate fechCad = LocalDate.parse("08 04 2028", DateTimeFormatter.ofPattern("dd MM yyyy"));
        LocalDate fechEnt = LocalDate.parse("08 09 2021", DateTimeFormatter.ofPattern("dd MM yyyy")); 
       
        /*LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyy");
        String text = date.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);*/

        equipo1.setFechaFabricacion(fechFab);
        equipo1.setFechaCaducidad(fechCad);
        equipo1.setFechaEntrega(fechEnt);
        equipo1.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo1.setSenaletica(false);
        equipo1.setCondicionUsado(false);
        equipo1.setDocUsoCreada(false);
        equipo1.setAsignado(false);
        //equipoRepositorio.save(equipo1);


        Equipo equipo2=new Equipo();
        equipo2.setNumSerie("12221333");
        equipo2.setMarca("Vital");
        equipo2.setModelo("Antiguo");
        equipo2.setFabricante("Samsung");
        equipo2.setOperador("Vodafone");
        equipo2.setPin("123888");
        equipo2.setPuk("0235");
        equipo2.setCodAiviago("8321");
        equipo2.setNumtlfnoAiviago("877456609");
        equipo2.setRefCabina("A08");
        equipo2.setNumSerieCabina("112555");
        fechFab = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("08 04 2028", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 11 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo2.setFechaFabricacion(fechFab);
        equipo2.setFechaCaducidad(fechCad);
        equipo2.setFechaEntrega(fechEnt);
        equipo2.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo2.setSenaletica(false);
        equipo2.setCondicionUsado(false);
        equipo2.setDocUsoCreada(false);
        equipo2.setAsignado(false);
        //equipoRepositorio.save(equipo2);



        Equipo equipo3=new Equipo();
        equipo3.setNumSerie("12221222");
        equipo3.setMarca("Rock");
        equipo3.setModelo("Moderno");
        equipo3.setFabricante("Huawei");
        equipo3.setOperador("Orange");
        equipo3.setPin("233345");
        equipo3.setPuk("7643");
        equipo3.setCodAiviago("0087");
        equipo3.setNumtlfnoAiviago("875653212");
        equipo3.setRefCabina("A09");
        equipo3.setNumSerieCabina("443221");
        fechFab = LocalDate.parse("12 02 2022", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("12 02 2030", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("01 03 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo3.setFechaFabricacion(fechFab);
        equipo3.setFechaCaducidad(fechCad);
        equipo3.setFechaEntrega(fechEnt);
        equipo3.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo3.setSenaletica(false);
        equipo3.setCondicionUsado(false);
        equipo3.setDocUsoCreada(false);
        equipo3.setAsignado(false);
        //equipoRepositorio.save(equipo3);


        Equipo equipo4=new Equipo();
        equipo4.setNumSerie("12224444");
        equipo4.setMarca("Rock");
        equipo4.setModelo("Moderno");
        equipo4.setFabricante("Huawei");
        equipo4.setOperador("Vodafone");
        equipo4.setPin("123567");
        equipo4.setPuk("0306");
        equipo4.setCodAiviago("8877");
        equipo4.setNumtlfnoAiviago("875432177");
        equipo4.setRefCabina("A10");
        equipo4.setNumSerieCabina("112999");
        fechFab = LocalDate.parse("07 08 2022", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("07 08 2030", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("23 03 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo4.setFechaFabricacion(fechFab);
        equipo4.setFechaCaducidad(fechCad);
        equipo4.setFechaEntrega(fechEnt);
        equipo4.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo4.setSenaletica(false);
        equipo4.setCondicionUsado(false);
        equipo4.setDocUsoCreada(false);
        equipo4.setAsignado(false);

        //equipoRepositorio.save(equipo4);


        Equipo equipo5=new Equipo();
        equipo5.setNumSerie("12225555");
        equipo5.setMarca("Vital");
        equipo5.setModelo("Antiguo");
        equipo5.setFabricante("Samsung");
        equipo5.setOperador("Vodafone");
        equipo5.setPin("116876");
        equipo5.setPuk("3546");
        equipo5.setCodAiviago("8899");
        equipo5.setNumtlfnoAiviago("875879021");
        equipo5.setRefCabina("A11");
        equipo5.setNumSerieCabina("115632");
        fechFab = LocalDate.parse("08 10 2018", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("08 10 2026", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("11 09 2019", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo5.setFechaFabricacion(fechFab);
        equipo5.setFechaCaducidad(fechCad);
        equipo5.setFechaEntrega(fechEnt);
        equipo5.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo5.setSenaletica(false);
        equipo5.setCondicionUsado(false);
        equipo5.setDocUsoCreada(false);
        equipo5.setAsignado(false);
        //equipoRepositorio.save(equipo5);


        Equipo equipo6=new Equipo();
        equipo6.setNumSerie("12266666");
        equipo6.setMarca("Vital");
        equipo6.setModelo("Actual");
        equipo6.setFabricante("Samsung");
        equipo6.setOperador("Vodafone");
        equipo6.setPin("128733");
        equipo6.setPuk("0211");
        equipo6.setCodAiviago("6654");
        equipo6.setNumtlfnoAiviago("877887766");
        equipo6.setRefCabina("A12");
        equipo6.setNumSerieCabina("118865");
        fechFab = LocalDate.parse("17 04 2021", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("17 04 2029", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 06 2022", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo6.setFechaFabricacion(fechFab);
        equipo6.setFechaCaducidad(fechCad);
        equipo6.setFechaEntrega(fechEnt);
        equipo6.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo6.setSenaletica(false);
        equipo6.setCondicionUsado(false);
        equipo6.setDocUsoCreada(false);
        equipo6.setAsignado(false);
        //equipoRepositorio.save(equipo6);

        Equipo equipo7=new Equipo();
        equipo7.setNumSerie("12227777");
        equipo7.setMarca("Rock");
        equipo7.setModelo("Antiguo");
        equipo7.setFabricante("Phillips");
        equipo7.setOperador("yoigo");
        equipo7.setPin("123443");
        equipo7.setPuk("0210");
        equipo7.setCodAiviago("5647");
        equipo7.setNumtlfnoAiviago("878909090");
        equipo7.setRefCabina("A13");
        equipo7.setNumSerieCabina("112334");
        fechFab = LocalDate.parse("11 03 2022", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("11 03 2030", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("07 11 2022", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo7.setFechaFabricacion(fechFab);
        equipo7.setFechaCaducidad(fechCad);
        equipo7.setFechaEntrega(fechEnt);
        equipo7.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo7.setSenaletica(false);
        equipo7.setCondicionUsado(false);
        equipo7.setDocUsoCreada(false);
        equipo7.setAsignado(false);
        //equipoRepositorio.save(equipo7);

        Equipo equipo8=new Equipo();
        equipo8.setNumSerie("12226785");
        equipo8.setMarca("Vital");
        equipo8.setModelo("Actual");
        equipo8.setFabricante("Huawei");
        equipo8.setOperador("yoigo");
        equipo8.setPin("148392");
        equipo8.setPuk("3856");
        equipo8.setCodAiviago("7444");
        equipo8.setNumtlfnoAiviago("872006543");
        equipo8.setRefCabina("A13");
        equipo8.setNumSerieCabina("112743");
        fechFab = LocalDate.parse("14 04 2021", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("14 04 2029", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("18 05 2022", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo8.setFechaFabricacion(fechFab);
        equipo8.setFechaCaducidad(fechCad);
        equipo8.setFechaEntrega(fechEnt);
        equipo8.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo8.setSenaletica(false);
        equipo8.setCondicionUsado(false);
        equipo8.setDocUsoCreada(false);
        equipo8.setAsignado(false);
        //equipoRepositorio.save(equipo8);

        Equipo equipo9=new Equipo();
        equipo9.setNumSerie("12278885");
        equipo9.setMarca("Rock");
        equipo9.setModelo("Antiguo");
        equipo9.setFabricante("Phillips");
        equipo9.setOperador("pepephone");
        equipo9.setPin("124483");
        equipo9.setPuk("5559");
        equipo9.setCodAiviago("0982");
        equipo9.setNumtlfnoAiviago("873002274");
        equipo9.setRefCabina("A14");
        equipo9.setNumSerieCabina("144539");
        fechFab = LocalDate.parse("20 08 2018", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("20 08 2026", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("19 04 2019", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo9.setFechaFabricacion(fechFab);
        equipo9.setFechaCaducidad(fechCad);
        equipo9.setFechaEntrega(fechEnt);
        equipo9.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo9.setSenaletica(false);
        equipo9.setCondicionUsado(false);
        equipo9.setDocUsoCreada(false);
        equipo9.setAsignado(false);
        //equipoRepositorio.save(equipo9);


        Equipo equipo10=new Equipo();
        equipo10.setNumSerie("12948371");
        equipo10.setMarca("Vital");
        equipo10.setModelo("Antiguo");
        equipo10.setFabricante("Samsung");
        equipo10.setOperador("Vodafone");
        equipo10.setPin("185034");
        equipo10.setPuk("1833");
        equipo10.setCodAiviago("0484");
        equipo10.setNumtlfnoAiviago("877994651");
        equipo10.setRefCabina("A15");
        equipo10.setNumSerieCabina("155589");
        fechFab = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("08 04 2028", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 11 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo10.setFechaFabricacion(fechFab);
        equipo10.setFechaCaducidad(fechCad);
        equipo10.setFechaEntrega(fechEnt);
        equipo10.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo10.setSenaletica(false);
        equipo10.setCondicionUsado(false);
        equipo10.setDocUsoCreada(false);
        equipo10.setAsignado(false);


        Equipo equipo11=new Equipo();
        equipo11.setNumSerie("12999543");
        equipo11.setMarca("Vital");
        equipo11.setModelo("Moderno");
        equipo11.setFabricante("Phillips");
        equipo11.setOperador("Vodafone");
        equipo11.setPin("185544");
        equipo11.setPuk("5467");
        equipo11.setCodAiviago("0888");
        equipo11.setNumtlfnoAiviago("877900987");
        equipo11.setRefCabina("A30Exterior");
        equipo11.setNumSerieCabina("155666");
        fechFab = LocalDate.parse("08 04 2016", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("08 04 2024", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 03 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo11.setFechaFabricacion(fechFab);
        equipo11.setFechaCaducidad(fechCad);
        equipo11.setFechaEntrega(fechEnt);
        equipo11.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo11.setSenaletica(true);
        equipo11.setCondicionUsado(true);
        equipo11.setDocUsoCreada(false);
        equipo11.setAsignado(false);


        Equipo equipo12=new Equipo();
        equipo12.setNumSerie("12911111");
        equipo12.setMarca("Terra");
        equipo12.setModelo("West");
        equipo12.setFabricante("Hitachi");
        equipo12.setOperador("Amena");
        equipo12.setPin("185432");
        equipo12.setPuk("8876");
        equipo12.setCodAiviago("0855");
        equipo12.setNumtlfnoAiviago("877999865");
        equipo12.setRefCabina("A29Exterior");
        equipo12.setNumSerieCabina("155453");
        fechFab = LocalDate.parse("11 05 2016", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("11 05 2026", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 10 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo12.setFechaFabricacion(fechFab);
        equipo12.setFechaCaducidad(fechCad);
        equipo12.setFechaEntrega(fechEnt);
        equipo12.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo12.setSenaletica(true);
        equipo12.setCondicionUsado(true);
        equipo12.setDocUsoCreada(false);
        equipo12.setAsignado(false);


        Equipo equipo13=new Equipo();
        equipo13.setNumSerie("12922222");
        equipo13.setMarca("Aqua");
        equipo13.setModelo("West");
        equipo13.setFabricante("Hitachi");
        equipo13.setOperador("Amena");
        equipo13.setPin("185443");
        equipo13.setPuk("8222");
        equipo13.setCodAiviago("0954");
        equipo13.setNumtlfnoAiviago("877988876");
        equipo13.setRefCabina("A28Exterior");
        equipo13.setNumSerieCabina("155453");
        fechFab = LocalDate.parse("21 08 2016", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("21 08 2024", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("01 02 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo13.setFechaFabricacion(fechFab);
        equipo13.setFechaCaducidad(fechCad);
        equipo13.setFechaEntrega(fechEnt);
        equipo13.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo13.setSenaletica(true);
        equipo13.setCondicionUsado(false);
        equipo13.setDocUsoCreada(false);
        equipo13.setAsignado(false);


        Equipo equipo14=new Equipo();
        equipo14.setNumSerie("12933333");
        equipo14.setMarca("Terra");
        equipo14.setModelo("Oest");
        equipo14.setFabricante("Hitachi");
        equipo14.setOperador("Vodafone");
        equipo14.setPin("122312");
        equipo14.setPuk("8777");
        equipo14.setCodAiviago("0998");
        equipo14.setNumtlfnoAiviago("877944432");
        equipo14.setRefCabina("A30Exterior");
        equipo14.setNumSerieCabina("155444");
        fechFab = LocalDate.parse("11 05 2017", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechCad = LocalDate.parse("11 05 2025", DateTimeFormatter.ofPattern("dd MM yyyy"));
        fechEnt = LocalDate.parse("15 10 2023", DateTimeFormatter.ofPattern("dd MM yyyy")); 
        equipo14.setFechaFabricacion(fechFab);
        equipo14.setFechaCaducidad(fechCad);
        equipo14.setFechaEntrega(fechEnt);
        equipo14.setFechaMantenimiento(fechEnt.plusYears(1));
        equipo14.setSenaletica(true);
        equipo14.setCondicionUsado(true);
        equipo14.setDocUsoCreada(false);
        equipo14.setAsignado(false);


      
        //Persistencia de clientes
      Cliente alumasa= new Cliente();

      alumasa.setCif("A12223111");
      alumasa.setNombEmp("Alumasa SA");
      alumasa.setNombre("Antonio");
      alumasa.setApellidos("Depedro Perez");
      alumasa.setDni("12322333i");
      alumasa.setDireccionFiscal("C/Alameda 21 1C 50002 Zaragoza");
      alumasa.setComercial("Alonso Garcia");

      Cliente ferrosa= new Cliente();

      ferrosa.setCif("A45667788");
      ferrosa.setNombEmp("Ferrosa SA");
      ferrosa.setNombre("Raul");
      ferrosa.setApellidos("Quino Laiz");
      ferrosa.setDni("14786634s");
      ferrosa.setDireccionFiscal("C/Ronda 36 6C 32018 Madrid");
      ferrosa.setComercial("Mario Bueno");

      Cliente transina= new Cliente();

      transina.setCif("A13560989");
      transina.setNombre("Juan");
      transina.setNombEmp("Transina SA");
      transina.setApellidos("Perez Sanz");
      transina.setDni("16887352h");
      transina.setDireccionFiscal("C/Tornasol 2 1E 33534 Madrid");
      transina.setComercial("Ines Sadaba");

      Cliente balay= new Cliente();

      balay.setCif("A44561234");
      balay.setNombEmp("Balay SA");
      balay.setNombre("Jaime");
      balay.setApellidos("Almonte Ruina");
      balay.setDni("11138943p");
      balay.setDireccionFiscal("C/Sta Isabel 217  50320 Zaragoza");
      balay.setComercial("Unai Val");


      //Persistencia de espacios
      Espacio espacio1=new Espacio();
      espacio1.setCliente(alumasa);
      espacio1.setDireccion("c/Francisco Victoria 26 50012 Zaragoza");
      espacio1.setEmail("alumasa@gmail.com");
      espacio1.setNumTelef("976132324");
      espacio1.setHorario("8,30-15,00");
      LocalDate fechReg= LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      espacio1.setFechRegDga(fechReg);

      Espacio espacio2=new Espacio();
      espacio2.setCliente(alumasa);
      espacio2.setDireccion("c/Pedro Arcano 12 45012 Huesca");
      espacio2.setEmail("alumasa@gmail.com");
      espacio2.setNumTelef("974135467");
      espacio2.setHorario("8,30-15,00");
      fechReg= LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      espacio2.setFechRegDga(fechReg);

      Espacio espacio3=new Espacio();
      espacio3.setCliente(ferrosa);
      espacio3.setDireccion("c/Tomas Oñate 267 50380 Zaragoza");
      espacio3.setEmail("ferrosa@gmail.com");
      espacio3.setNumTelef("976334412");
      espacio3.setHorario("9,00-16,00");
      fechReg= LocalDate.parse("18 06 2022", DateTimeFormatter.ofPattern("dd MM yyyy"));
      espacio3.setFechRegDga(fechReg);

      Espacio espacio4=new Espacio();
      espacio4.setCliente(transina);
      espacio4.setDireccion("c/Francisco Remo 321 50812 Zaragoza");
      espacio4.setEmail("transina@gmail.com");
      espacio4.setNumTelef("976554986");
      espacio4.setHorario("8,30-15,00");
      fechReg= LocalDate.parse("15 01 2021", DateTimeFormatter.ofPattern("dd MM yyyy"));
      espacio4.setFechRegDga(fechReg);
      
      Espacio espacio5=new Espacio();
      espacio5.setCliente(balay);
      espacio5.setDireccion("C/Sta Isabel 217  50320 Zaragoza");
      espacio5.setEmail("balay@gmail.com");
      espacio5.setNumTelef("976235632");
      espacio5.setHorario("9,00-16,00");
      fechReg= LocalDate.parse("27 11 2023", DateTimeFormatter.ofPattern("dd MM yyyy"));
      espacio5.setFechRegDga(fechReg);

      
      
//Persistencia de lugares
      Lugar nave1=new Lugar();
      nave1.setUbicacion("almacen edificio3");
      nave1.setEspacio(espacio1);
      nave1.setEquipo(equipo1);
      equipo1.setAsignado(true);

      Lugar nave2=new Lugar();
      nave2.setUbicacion("recepcion");
      nave2.setEspacio(espacio2);
      nave2.setEquipo(equipo4);
      equipo4.setAsignado(true);

      Lugar nave3=new Lugar();
      nave3.setUbicacion("oficinas planta 2");
      nave3.setEspacio(espacio3);
      nave3.setEquipo(equipo5);
      equipo5.setAsignado(true);

      Lugar nave4=new Lugar();
      nave4.setUbicacion("almacen");
      nave4.setEspacio(espacio4);
      nave4.setEquipo(equipo6);
      equipo6.setAsignado(true);

      Lugar nave5=new Lugar();
      nave5.setUbicacion("recepcion");
      nave5.setEspacio(espacio5);
      nave5.setEquipo(equipo7);
      equipo7.setAsignado(true);
      
      //Persistencia de vehiculos
      Vehiculo vehiculo1=new Vehiculo();
      vehiculo1.setUbicacion("vehiculo1 en parking");
      vehiculo1.setEspacio(espacio1);
      vehiculo1.setEquipo(equipo2);
      equipo2.setAsignado(true);
      vehiculo1.setMarca("SEAT");
      vehiculo1.setModelo("ALHAMBRA");
      vehiculo1.setMatricula("0788GGH");
      vehiculo1.setTelefono("654773245");
      //vehiculo1.setLugar(parking);
      

      Vehiculo vehiculo2=new Vehiculo();
      vehiculo2.setUbicacion("vehiculo2 en parking");
      vehiculo2.setEspacio(espacio1);
      vehiculo2.setEquipo(equipo3);
      equipo3.setAsignado(true);
      vehiculo2.setMarca("FORD");
      vehiculo2.setModelo("TRANSIT");
      vehiculo2.setMatricula("5678PLK");
      vehiculo2.setTelefono("654443267"); 
      //vehiculo2.setLugar(parking);

      Vehiculo vehiculo3=new Vehiculo();
      vehiculo3.setUbicacion("vehiculo1 en parking");
      vehiculo3.setEspacio(espacio5);
      vehiculo3.setEquipo(equipo8);
      equipo8.setAsignado(true);
      vehiculo3.setMarca("FORD");
      vehiculo3.setModelo("TRANSIT");
      vehiculo3.setMatricula("4766BBZ");
      vehiculo3.setTelefono("654987654"); 

     
     
     
     //Persistencia de cursos
      Curso curso1=new Curso();
      curso1.setCliente(alumasa);
      curso1.setNombre("alumasagrupo1");
      
      Curso curso2=new Curso();
      curso2.setCliente(alumasa);
      curso2.setNombre("alumasagrupo2");

      Curso curso3=new Curso();
      curso3.setCliente(ferrosa);
      curso3.setNombre("ferrosagrupo1");
      
      Curso curso4=new Curso();
      curso4.setCliente(transina);
      curso4.setNombre("transinagrupo1");

      Curso curso5=new Curso();
      curso5.setCliente(balay);
      curso5.setNombre("balaygrupo1");

      //persistencia de diplomas
      Diploma diplomaal11=new Diploma();
      Diploma diplomaal12=new Diploma();
      Diploma diplomaal21=new Diploma();
      Diploma diplomaal22=new Diploma();
      Diploma diplomafe1=new Diploma();
      Diploma diplomafe2=new Diploma();
      Diploma diplomatr1=new Diploma();
      Diploma diplomatr2=new Diploma();
      Diploma diplomaba11=new Diploma();
      Diploma diplomaba12=new Diploma();
      Diploma diplomaba21=new Diploma();
      Diploma diplomaba22=new Diploma();
     
      
      //Persistencia de formaciones
      Formacion formacional1=new Formacion();
      Formacion formacional2=new Formacion();
      Formacion formacionfe=new Formacion();
      Formacion formaciontr=new Formacion();
      Formacion formacionba1=new Formacion();
      Formacion formacionba2=new Formacion();

      Set<Diploma> diplomasal1=new HashSet<Diploma>();
      diplomasal1.add(diplomaal11);
      diplomasal1.add(diplomaal12);
      Set<Diploma> diplomasal2=new HashSet<Diploma>();
      diplomasal2.add(diplomaal21);
      diplomasal2.add(diplomaal22);
      Set<Diploma> diplomasfe=new HashSet<Diploma>();
      diplomasfe.add(diplomafe1);
      diplomasfe.add(diplomafe2);
      Set<Diploma> diplomastr=new HashSet<Diploma>();
      diplomastr.add(diplomatr1);
      diplomastr.add(diplomatr2);
      Set<Diploma> diplomasba1=new HashSet<Diploma>();
      diplomasba1.add(diplomaba11);
      diplomasba1.add(diplomaba12);
      Set<Diploma> diplomasba2=new HashSet<Diploma>();
      diplomasba2.add(diplomaba21);
      diplomasba2.add(diplomaba22);

      
     
      //Persistencia de alumnos
      Alumno alumno1=new Alumno();
      alumno1.setDniAlumno("12345987h");
      alumno1.setNombre("Alejandro");
      alumno1.setApellidos("Gomez Jurado");
      alumno1.setFormacion(formacional1);

      Alumno alumno2=new Alumno();
      alumno2.setDniAlumno("14357343j");
      alumno2.setNombre("Antonio");
      alumno2.setApellidos("Hernandez Gomez");
      alumno2.setFormacion(formacional1);

      Alumno alumno3=new Alumno();
      alumno3.setDniAlumno("23727632f");
      alumno3.setNombre("Pedro");
      alumno3.setApellidos("Garcia Jurado");
      alumno3.setFormacion(formacional2);

      Alumno alumno4=new Alumno();
      alumno4.setDniAlumno("87342309i");
      alumno4.setNombre("Tomas");
      alumno4.setApellidos("Asiain Perez");
      alumno4.setFormacion(formacional2);

      Alumno alumno5=new Alumno();
      alumno5.setDniAlumno("12398745t");
      alumno5.setNombre("Ana");
      alumno5.setApellidos("Tornado Ramos");
      alumno5.setFormacion(formacionfe);

      Alumno alumno6=new Alumno();
      alumno6.setDniAlumno("14238854g");
      alumno6.setNombre("Isabel");
      alumno6.setApellidos("Herrero Alsina");
      alumno6.setFormacion(formacionfe);

      Alumno alumno7=new Alumno();
      alumno7.setDniAlumno("14335677c");
      alumno7.setNombre("Pelayo");
      alumno7.setApellidos("Hernandez Torras");
      alumno7.setFormacion(formaciontr);

      Alumno alumno8=new Alumno();
      alumno8.setDniAlumno("98432226c");
      alumno8.setNombre("Manuel");
      alumno8.setApellidos("Diaz Arosa");
      alumno8.setFormacion(formaciontr);

      Alumno alumno9=new Alumno();
      alumno9.setDniAlumno("12333444f");
      alumno9.setNombre("Sara");
      alumno9.setApellidos("Gomez Luna");
      alumno9.setFormacion(formacionba1);

      Alumno alumno10=new Alumno();
      alumno10.setDniAlumno("29987654d");
      alumno10.setNombre("Maria");
      alumno10.setApellidos("Marquina Sanchez");
      alumno10.setFormacion(formacionba1);

      Alumno alumno11=new Alumno();
      alumno11.setDniAlumno("14326698v");
      alumno11.setNombre("Miguel");
      alumno11.setApellidos("Gimenez Marin");
      alumno11.setFormacion(formacionba2);

      Alumno alumno12=new Alumno();
      alumno12.setDniAlumno("14332589l");
      alumno12.setNombre("Silvia");
      alumno12.setApellidos("Gomez Martin");
      alumno12.setFormacion(formacionba2);


      Set<Alumno> alumnosal1=new HashSet<Alumno>();
      alumnosal1.add(alumno1);
      alumnosal1.add(alumno2);
      Set<Alumno> alumnosal2=new HashSet<Alumno>();
      alumnosal2.add(alumno3);
      alumnosal2.add(alumno4);
      Set<Alumno> alumnosfe=new HashSet<Alumno>();
      alumnosfe.add(alumno5);
      alumnosfe.add(alumno6);
      Set<Alumno> alumnostr=new HashSet<Alumno>();
      alumnostr.add(alumno7);
      alumnostr.add(alumno8);
      Set<Alumno> alumnosba1=new HashSet<Alumno>();
      alumnosba1.add(alumno9);
      alumnosba1.add(alumno10);
      Set<Alumno> alumnosba2=new HashSet<Alumno>();
      alumnosba2.add(alumno11);
      alumnosba2.add(alumno12);
     
      


      formacional1.setTipo("inicial");
      formacional1.setNumAsistentes(alumnosal1.size());
      LocalDate fechFor = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formacional1.setDateFormacion(fechFor);
      formacional1.setSenaletica(false);
      formacional1.setEstado(false);
      formacional1.setRecuerdo(fechFor.plusYears(1));
      //formacional1.setDiploma(diplomasal1);
      formacional1.setCurso(curso1);
      formacional1.setImpartidor("Daniel Perez Pardos");
      formacional1.setAlumnos(alumnosal1);
      

      formacional2.setTipo("repaso");
      formacional2.setNumAsistentes(alumnosal2.size());
      fechFor = LocalDate.parse("08 04 2021", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formacional2.setDateFormacion(fechFor);
      formacional2.setSenaletica(false);
      formacional2.setEstado(false);
      formacional2.setRecuerdo(fechFor.plusYears(1));
      //formacional2.setDiploma(diplomasal2);
      formacional2.setCurso(curso1);
      formacional2.setImpartidor("Jorge Novellon Grañena");
      formacional2.setAlumnos(alumnosal2);

      formacionfe.setTipo("inicial");
      formacionfe.setNumAsistentes(alumnosfe.size());
      fechFor = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formacionfe.setDateFormacion(fechFor);
      formacionfe.setSenaletica(false);
      formacionfe.setEstado(false);
      formacionfe.setRecuerdo(fechFor.plusYears(1));
      //formacionfe.setDiploma(diplomasfe);
      formacionfe.setCurso(curso2);
      formacionfe.setImpartidor("Daniel Perez Pardos");
      formacionfe.setAlumnos(alumnosfe);

      formaciontr.setTipo("inicial");
      formaciontr.setNumAsistentes(alumnostr.size());
      fechFor = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formaciontr.setDateFormacion(fechFor);
      formaciontr.setSenaletica(false);
      formaciontr.setEstado(false);
      formaciontr.setRecuerdo(fechFor.plusYears(1));
     // formaciontr.setDiploma(diplomastr);
      formaciontr.setCurso(curso3);
      formaciontr.setImpartidor("Daniel Perez Pardos");
      formaciontr.setAlumnos(alumnostr);

      
      formacionba1.setTipo("inicial");
      formacionba1.setNumAsistentes(alumnosba1.size());
      fechFor = LocalDate.parse("08 04 2020", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formacionba1.setDateFormacion(fechFor);
      formacionba1.setSenaletica(false);
      formacionba1.setEstado(false);
      formacionba1.setRecuerdo(fechFor.plusYears(1));
      //formacionba1.setDiploma(diplomasba1);
      formacionba1.setCurso(curso4);
      formacionba1.setImpartidor("Daniel Perez Pardos");
      formacionba1.setAlumnos(alumnosba1);

      formacionba2.setTipo("repaso");
      formacionba2.setNumAsistentes(alumnosba2.size());
      fechFor = LocalDate.parse("08 04 2021", DateTimeFormatter.ofPattern("dd MM yyyy"));
      formacionba2.setDateFormacion(fechFor);
      formacionba2.setSenaletica(false);
      formacionba2.setEstado(false);
      formacionba2.setRecuerdo(fechFor.plusYears(1));
      //formacionba2.setDiploma(diplomasba2);
      formacionba2.setCurso(curso4);
      formacionba2.setImpartidor("Jorge Novellon Grañena");
      formacionba2.setAlumnos(alumnosba2);




      clienteRepositorio.save(alumasa);
      clienteRepositorio.save(ferrosa);
      clienteRepositorio.save(transina);
      clienteRepositorio.save(balay);

      espacioRepositorio.save(espacio1);
      espacioRepositorio.save(espacio2);
      espacioRepositorio.save(espacio3);
      espacioRepositorio.save(espacio4);
      espacioRepositorio.save(espacio5);
   
 

      equipoRepositorio.save(equipo1);
      equipoRepositorio.save(equipo2);
      equipoRepositorio.save(equipo3);
      equipoRepositorio.save(equipo4);
      equipoRepositorio.save(equipo5);
      equipoRepositorio.save(equipo6);
      equipoRepositorio.save(equipo7);
      equipoRepositorio.save(equipo8);
      equipoRepositorio.save(equipo9);
      equipoRepositorio.save(equipo10);
      equipoRepositorio.save(equipo11);
      equipoRepositorio.save(equipo12);
      equipoRepositorio.save(equipo13);



      lugarRepositorio.save(nave1);
      lugarRepositorio.save(nave2);
      lugarRepositorio.save(nave3);
      lugarRepositorio.save(nave4);
      lugarRepositorio.save(nave5);
      vehiculoRepositorio.save(vehiculo1);
      vehiculoRepositorio.save(vehiculo2);
      vehiculoRepositorio.save(vehiculo3);


      cursoRepositorio.save(curso1);
      cursoRepositorio.save(curso2);
      cursoRepositorio.save(curso3);
      cursoRepositorio.save(curso4);
      cursoRepositorio.save(curso5);
      
      formacionRepositorio.save(formacional1);
      formacionRepositorio.save(formacional2);
      formacionRepositorio.save(formacionfe);
      formacionRepositorio.save(formaciontr);
      formacionRepositorio.save(formacionba1);
      formacionRepositorio.save(formacionba2);
      
       
      alumnoRepositorio.save(alumno1);
      alumnoRepositorio.save(alumno2);
      alumnoRepositorio.save(alumno3);
      alumnoRepositorio.save(alumno4);
      alumnoRepositorio.save(alumno5);
      alumnoRepositorio.save(alumno6);
      alumnoRepositorio.save(alumno7);
      alumnoRepositorio.save(alumno8);
      alumnoRepositorio.save(alumno9);
      alumnoRepositorio.save(alumno10);
      alumnoRepositorio.save(alumno11);
      alumnoRepositorio.save(alumno12);


      Alumno[] arrayalumal1=new Alumno[alumnosal1.size()];
      alumnosal1.toArray(arrayalumal1);
      Diploma[] arraydipal1=new Diploma[diplomasal1.size()];
      diplomasal1.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }

     
      alumnosal2.toArray(arrayalumal1);
      
      diplomasal2.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }

    
      alumnosfe.toArray(arrayalumal1);
      
      diplomasfe.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }
      
      
      alumnostr.toArray(arrayalumal1);
      
      diplomastr.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }
      
      alumnosba1.toArray(arrayalumal1);
      
      diplomasba1.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }

      alumnosba2.toArray(arrayalumal1);
      
      diplomasba2.toArray(arraydipal1);
      
      for (int x=0;x<2;x++) {
         arraydipal1[x].setAlumno(arrayalumal1[x]);
         arraydipal1[x].setNombre(arrayalumal1[x].getNombre());
         arraydipal1[x].setApellidos(arrayalumal1[x].getApellidos());
         arraydipal1[x].setDni(arrayalumal1[x].getDniAlumno());
         arraydipal1[x].setFecha(arrayalumal1[x].getFormacion().getDateFormacion());
         arraydipal1[x].setImpartidor(arrayalumal1[x].getFormacion().getImpartidor());
         arraydipal1[x].setFormacion(arrayalumal1[x].getFormacion());
         arrayalumal1[x].setDiploma(arraydipal1[x]);
      }

      diplomaRepositorio.save(diplomaal11);
      diplomaRepositorio.save(diplomaal12);
      diplomaRepositorio.save(diplomaal21);
      diplomaRepositorio.save(diplomaal22);
      diplomaRepositorio.save(diplomafe1);
      diplomaRepositorio.save(diplomafe2);
      diplomaRepositorio.save(diplomatr1);
      diplomaRepositorio.save(diplomatr2);
      diplomaRepositorio.save(diplomaba11);
      diplomaRepositorio.save(diplomaba12);
      diplomaRepositorio.save(diplomaba21);
      diplomaRepositorio.save(diplomaba22);

  
      alumnoRepositorio.save(alumno1);
      alumnoRepositorio.save(alumno2);
      alumnoRepositorio.save(alumno3);
      alumnoRepositorio.save(alumno4);
      alumnoRepositorio.save(alumno5);
      alumnoRepositorio.save(alumno6);
      alumnoRepositorio.save(alumno7);
      alumnoRepositorio.save(alumno8);
      alumnoRepositorio.save(alumno9);
      alumnoRepositorio.save(alumno10);
      alumnoRepositorio.save(alumno11);
      alumnoRepositorio.save(alumno12);
     
      

    /*  alumnoRepositorio.save(alumno2);
      alumnoRepositorio.save(alumno3);
      alumnoRepositorio.save(alumno4);
      alumnoRepositorio.save(alumno5);
      alumnoRepositorio.save(alumno6);
      alumnoRepositorio.save(alumno7);
      alumnoRepositorio.save(alumno8);
      alumnoRepositorio.save(alumno9);
      alumnoRepositorio.save(alumno10);
      alumnoRepositorio.save(alumno11);
      alumnoRepositorio.save(alumno12);
      alumnoRepositorio.save(alumno13);
      alumnoRepositorio.save(alumno14);
      alumnoRepositorio.save(alumno15);
      alumnoRepositorio.save(alumno16);
      alumnoRepositorio.save(alumno17);
      alumnoRepositorio.save(alumno18);
      alumnoRepositorio.save(alumno19);
      alumnoRepositorio.save(alumno20);
      alumnoRepositorio.save(alumno21);
      alumnoRepositorio.save(alumno22);
      alumnoRepositorio.save(alumno23);
      alumnoRepositorio.save(alumno24);
      alumnoRepositorio.save(alumno25);
      alumnoRepositorio.save(alumno26);
      alumnoRepositorio.save(alumno27);
      alumnoRepositorio.save(alumno28);
      alumnoRepositorio.save(alumno29);
      alumnoRepositorio.save(alumno30);
      alumnoRepositorio.save(alumno31);
      alumnoRepositorio.save(alumno32); */ 


     
      //lugarRepositorio.save(parking);
     


}
}