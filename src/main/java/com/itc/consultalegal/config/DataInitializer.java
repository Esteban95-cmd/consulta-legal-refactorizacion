package com.itc.consultalegal.config;

import com.itc.consultalegal.entity.Articulo;
import com.itc.consultalegal.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpiar la base de datos primero para evitar duplicados
        articuloRepository.deleteAll();
        
        System.out.println("Inicializando datos...");
        inicializarDatos();
        
        long count = articuloRepository.count();
        System.out.println("Datos iniciales cargados exitosamente! " + count + " artículos cargados.");
        
        List<Articulo> todos = articuloRepository.findAll();
        System.out.println("Artículos en la base de datos:");
        for (Articulo art : todos) {
            System.out.println(" - " + art.getNumeroArticulo() + ": " + art.getTitulo() + " (ID: " + art.getId() + ")");
        }
    }

    private void inicializarDatos() {
        List<Articulo> articulos = Arrays.asList(
            // Artículo 269A
            new Articulo(null, "269A", "Acceso abusivo a un sistema informático", "Ley 1273 de 2009", 
                "El que, sin autorización o por fuera de lo acordado, acceda en todo o en parte a un sistema informático protegido o no con alguna medida de seguridad, o se mantenga dentro del mismo en contra de la voluntad de quien tenga el legítimo derecho a excluirlo, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Acceso Físico (desde el equipo o terminal directamente afectado)",
                "1. Ingeniería Social. 2. Software Malicioso. 3. Phishing. 4. Vishing. 5. Smishing. 6. SIM SWAP. 7. Explotación de Vulnerabilidades"),

            // Artículo 269B
            new Articulo(null, "269B", "Obstaculización ilegítima de sistema informático o red de telecomunicación", "Ley 1273 de 2009",
                "El que sin estar facultado para ello, impida u obstaculice el funcionamiento o el acceso normal a un sistema informático, a los datos informáticos allí contenidos, o a una red de telecomunicaciones, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Impedir (inutilización absoluta) u Obstaculizar (inutilización parcial)",
                "1. Ransomware de bloqueo o de cifrado. 2. Ataque DoS. 3. Ataque DDoS. 4. Botnet. 5. Ataque DNS. 6. Buffer Overflow."),

            // Artículo 269C
            new Articulo(null, "269C", "Interceptación de datos informáticos", "Ley 1273 de 2009",
                "El que, sin autorización o por fuera de lo acordado, intercepte datos informáticos en su origen, destino o en el interior de un sistema informático o de una red de telecomunicación, o las emisiones electromagnéticas de un sistema informático que los transporte, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Interceptación de datos personales (sensibles, privados o semiprivados) o impersonales",
                "1. Se realiza por medios electrónicos, informáticos, ópticos, magnéticos. 2. Trojanos (Banker). 3. Ataque MitB Man in the browser. 4. Ataque MitM Man in the middle."),

            // Artículo 269D
            new Articulo(null, "269D", "Daño informático", "Ley 1273 de 2009",
                "El que, sin estar facultado para ello, destruya, dañe, borre, deteriore, altere o suprima datos informáticos, o un sistema de tratamiento de información o sus partes o componentes lógicos, incurrirá en pena de prisión de cuarenta y ocho (48) a ciento veinte (120) meses y en multa de 200 a 1500 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 120 meses y multa de 200 a 1.500 salarios mínimos legales mensuales vigentes.",
                "Daño informático o lógico sobre datos/sistemas o Daño físico sobre infraestructura informática",
                "1. Defacement. 2. Software Malicioso. 3. Inyección de código. 4. Daño físico de equipos. 5. Alteración, borrado o destrucción de Información."),

            // Artículo 269E
            new Articulo(null, "269E", "Uso de software malicioso", "Ley 1273 de 2009",
                "El que, sin autorización o por fuera de lo acordado, desarrolle, trafique, adquiera, distribuya, venda, envíe, introduzca o extraiga del territorio nacional software malicioso u otros programas de computador destinados a afectar datos informáticos, sistemas informáticos o redes de telecomunicación, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Desarrollo de software malicioso o Uso de software malicioso",
                "1. Software Malicioso (Malware, Virus, Troyanos, Ransomware, etc.)"),

            // Artículo 269F
            new Articulo(null, "269F", "Violación de datos personales", "Ley 1273 de 2009",
                "El que, sin autorización o por fuera de lo acordado, acceda, capture, intercepte, conozca, divulgue, modifique, suprima o use datos personales contenidos en ficheros, archivos, bases de datos o medios semejantes, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Vulneración de la Confidencialidad, Integridad y/o Disponibilidad de datos personales",
                "1. Ingeniería Social. 2. Software Malicioso. 3. Phishing. 4. Vishing. 5. Smishing. 6. Explotación de Vulnerabilidades"),

            // Artículo 269G
            new Articulo(null, "269G", "Suplantación de sitios web para capturar datos personales", "Ley 1273 de 2009",
                "El que, con el fin de obtener provecho para sí o para un tercero, diseñe, desarrolle, trafique, venda, ejecute, programe o envíe páginas electrónicas, enlaces o ventanas emergentes, incurrirá en pena de prisión de cuarenta y ocho (48) a noventa y seis (96) meses y en multa de 100 a 1000 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 96 meses y multa de 100 a 1.000 salarios mínimos legales mensuales vigentes.",
                "Desarrollo, Implementación, Comercialización o Utilización de sitios web suplantados",
                "1. Falsedad de identidad Virtual. 2. Phishing. 3. Vishing. 4. Smishing. 5. Explotación de Vulnerabilidades 6. Ingeniería Social"),

            // Artículo 269I
            new Articulo(null, "269I", "Hurto por medios informáticos y semejantes", "Ley 1273 de 2009",
                "El que, con el fin de obtener provecho para sí o para un tercero, superando medidas de seguridad informáticas, suplantando a un usuario ante los sistemas de autenticación y de autorización establecidos, o aprovechando una situación análoga, acceda en todo o en parte a un sistema informático, a los datos informáticos en él contenidos, o a una red de telecomunicaciones, y de esta manera dé lugar a la sustracción de cosa mueble ajena, incurrirá en pena de prisión de cuarenta y ocho (48) a ciento veinte (120) meses y en multa de 200 a 1500 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 120 meses y multa de 200 a 1.500 salarios mínimos legales mensuales vigentes.",
                "Apropiarse de un bien superando medidas de seguridad informáticas o suplantando a un usuario",
                "1. Ingeniería Social. 2. Software Malicioso. 3. Phishing. 4. Vishing. 5. Smishing. 6. SIM SWAP. 7. Explotación de Vulnerabilidades. 8. Insider. 9. Carding."),

            // Artículo 269J
            new Articulo(null, "269J", "Transferencia no Consentida de Activos", "Ley 1273 de 2009",
                "El que, con el fin de obtener provecho para sí o para un tercero, sin autorización o por fuera de lo acordado, realice transferencias no consentidas de activos mediante la utilización de técnicas de ingeniería social o medios informáticos, incurrirá en pena de prisión de cuarenta y ocho (48) a ciento veinte (120) meses y en multa de 200 a 1500 salarios mínimos legales mensuales vigentes.",
                "Código Penal", "Prisión de 48 a 120 meses y multa de 200 a 1.500 salarios mínimos legales mensuales vigentes.",
                "Transferencias NO consentidas o Trámito fraudulento",
                "1. Ingeniería Social. 2. Software Malicioso. 3. Phishing. 4. Vishing. 5. Smishing. 6. SIM SWAP. 7. Explotación de Vulnerabilidades. 8. Insider. 9. Carding.")
        );

        // Guardar todos los artículos
        articuloRepository.saveAll(articulos);
        System.out.println("Se intentaron guardar " + articulos.size() + " artículos");
    }
}