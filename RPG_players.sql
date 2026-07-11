-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 30-01-2026 a les 16:42:42
-- Versió del servidor: 10.4.32-MariaDB
-- Versió de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `RPG_players`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `magia`
--

CREATE TABLE `magia` (
  `id_magia` int(11) NOT NULL,
  `nombre_magia` varchar(50) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Bolcament de dades per a la taula `magia`
--

INSERT INTO `magia` (`id_magia`, `nombre_magia`, `descripcion`) VALUES
(1, 'Fuego', 'Poderosa magia no apta para noveles, su potencia radica en la llama interna de su portador. Suele ser un elemento difícil de dominar por su fiereza, pero en alto níveles de poder, muy confiable. La terquedad es su fuente de energía y de ella nace su fama'),
(2, 'Agua', 'La templanza y pureza del elemento de la vida, donde todo nacío. Aquellos que poseen este tipo de magía son puros y transparente, como el agua misma. Poseen altas habilidades de sanación pero no rozán el nível de otros elementos'),
(3, 'Tierra', 'El elemento mágico del equilibrio, donde todo se mantiene en un constante termino medio. Los magos del elemento de la tierra pueden ser fieros, tan a sí como relajados, pero nunca se desafía sus níveles de poder en campo abierto'),
(4, 'Rayo', 'Ágiles como ellos mismos, no dudan ni un momento en atacar si ven la oportunidad. La estrategía no es su fuerte, pero la astucia y rapidez con la que ejecutan, sabiendo aprovechar las oportunidades o aperturas son envidiables'),
(5, 'Hielo', 'A diferencia del elemento acuático, aquellos que manejan la magia del Hielo son fríos como un témpano e insurgentes. No tienen piedad y rara vez muestran sus sentimientos, pero no dudaran en destrozar a su oponente lentamente'),
(6, 'Luz', 'La pureza ejemplificada, como el elemento Agua, pero de tal brillantez que puedan dar sus vida por sus camaradas. Se centran en la curación a niveles más altos y soporte a todo el equipo, a si mismo rara vez atacan, pero cuando lo hacen sus hechizos son de alto poder destructivo'),
(7, 'Oscuridad', 'Comunmente conocidos como el mal personificado. Son poderosos hechiceros, destructores y despiedados... o eso es lo que siempre se ha querido creer de ellos. Solitarios, rebeldes, fuera del sistema; antihéroes que luchan por su propia justicia y grandes aliados. Alto poder mágico destructor'),
(8, 'Metal', 'La defensa perfecta. Guardianes insaciables, luchan por proteger sus defensas y las de sus camaradas. De gran constitución, nunca pierden la oportunidad de luchar por la justicia. La ejemplificación de la sensatez'),
(9, 'Caos', 'Tipo de magia extraña y de muy pocos usuarios. Aquellos que nacen con ella se consideran especiales, porque no solo pueden controlar la luz o la oscuridad, sino que además pueden desafiar las leyes del espacio-tiempo. Los \"Elegidos\" es como se llaman'),
(10, 'Divinidad', 'Simplemente dioses. Este tipo de magía solo ha sido vista una vez y solo una usuaria ha sido capaz de domarla. Destructora, justa. Domina por completo todo lo esencial que habita en el mundo');

-- --------------------------------------------------------

--
-- Estructura de la taula `personajes`
--

CREATE TABLE `personajes` (
  `id_personaje` int(11) NOT NULL,
  `nom_personaje` varchar(50) DEFAULT NULL,
  `localidad` varchar(100) DEFAULT NULL,
  `especialidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Bolcament de dades per a la taula `personajes`
--

INSERT INTO `personajes` (`id_personaje`, `nom_personaje`, `localidad`, `especialidad`) VALUES
(1, 'Draxler', 'Corpinyo', 1),
(2, 'Sarah', 'Urfasi', 2),
(3, 'Drakkon', 'Unkown Regions', 9),
(4, 'Arqui', 'Corpinyo', 4),
(5, 'Ettiona', 'Fassah', 3),
(6, 'Saffira', 'Sky World', 10);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `magia`
--
ALTER TABLE `magia`
  ADD PRIMARY KEY (`id_magia`);

--
-- Índexs per a la taula `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`id_personaje`),
  ADD KEY `especialidad` (`especialidad`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `magia`
--
ALTER TABLE `magia`
  MODIFY `id_magia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la taula `personajes`
--
ALTER TABLE `personajes`
  MODIFY `id_personaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `personajes`
--
ALTER TABLE `personajes`
  ADD CONSTRAINT `personajes_ibfk_1` FOREIGN KEY (`especialidad`) REFERENCES `magia` (`id_magia`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


/*Selects*/

SELECT * FROM `personajes`;

SELECT `nom_personaje` FROM `personajes` WHERE `id_personaje` >= 3;

SELECT `descripcion` FROM `magia` WHERE `nombre_magia` = 'FUEGO';

SELECT `nombre_magia` FROM `magia` WHERE `id_magia` BETWEEN 1 AND 6;

SELECT `localidad` FROM `personajes` WHERE `id_personaje` IN (2 , 5);

/*
 * En aquesta pràctica al ser una base de dades senzilleta
 * he priorizat el format front a fer-la complicada. No hi han subconsultes
 * donan que no compte amb moltes dades numériques.
 * Tampoc he vist necesàri fer res Sobre UPDATE O DELETE, encara que UPDATE nomes l'utilitzare
 * en cas de que algú lña vuiga corregir
 */