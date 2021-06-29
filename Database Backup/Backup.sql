-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: freedb.tech    Database: freedbtech_progExDatabase
-- ------------------------------------------------------
-- Server version	5.7.34-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sportart` varchar(20) DEFAULT NULL,
  `Datum` varchar(12) DEFAULT NULL,
  `Uhrzeit` varchar(5) DEFAULT NULL,
  `Postleitzahl` varchar(10) DEFAULT NULL,
  `Stadt` varchar(55) DEFAULT NULL,
  `Straße` varchar(70) DEFAULT NULL,
  `Hausnummer` varchar(50) DEFAULT NULL,
  `Anzahlplätze` int(11) DEFAULT NULL,
  `kosten` double DEFAULT NULL,
  `veranstalter` varchar(30) DEFAULT NULL,
  `xCoordinate` double DEFAULT NULL,
  `yCoordinate` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `veranstalter` (`veranstalter`),
  CONSTRAINT `event_ibfk_1` FOREIGN KEY (`veranstalter`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=427 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (398,'Gehen','22.9.2021','17:40',NULL,'null',NULL,NULL,NULL,0,'Schatzmeister3',50.10394166191986,8.403001427650452),(399,'Aerobic','2.6.2021','21:31',NULL,'null',NULL,NULL,NULL,0,'Schatzmeister3',50.1241275568655,8.666067123413086),(400,'Bergwandern','19.6.2021','11:00','60489','Frankfurt am Main','Eschborner Landstrasse','113',8,10,'Schatzmeister3',50.128512426082835,8.596887588500977),(401,'Beachvolleyball','25.6.2021','11:05','60489','Frankfurt am Main','Hausener Weg','94',12,10,'Schatzmeister3',50.13137355159331,8.618626892566681),(402,'Bergwandern','3.10.2021','13:00','47441','Kreis Wesel','Winkelhauser Strasse','7',999,0,'Schatzmeister3',51.43284042400513,6.6704124212265015),(403,'Aerobic','3.6.2021','13:02','06800','Anhalt-Bitterfeld','Kleine Gasse','13',34,0,'Schatzmeister3',51.685165177589944,12.29720950126648),(404,'Karate','30.6.2021','17:30','85368','Volkmannsdorf','Isarecker Feld','7',1,0,'Schatzmeister3',48.49718126063619,11.939574480056763),(405,'Hacky Sack','22.9.2021','18:36','22335','Hamburg-Nord','Erdkampsweg','134',999,0,'Schatzmeister3',53.63487414975716,10.014617443084717),(406,'Golf','23.9.2021','19:00','64823','Landkreis Darmstadt-Dieburg','Karlsbader Strasse','8',999,0,'Schatzmeister3',49.88212475028046,8.916322588920593),(407,'Tennis','16.6.2021','15:59','35392','Landkreis Giess?en','Leihgesterner Weg','52',4,0,'johannes',50.57251276307783,8.673105239868164),(409,'Inline-Skaten','25.6.2021','19:14','97944','Boxberg','Junkerholzweg','34',24,10,'Schatzmeister3',49.458278106725714,9.600269794464111),(410,'Aerobic','26.6.2021','18:20','97645','Ostheim v.d.Rhön','Burgstraße','27',998,0,'Schatzmeister3',50.46557017350023,10.227423906326294),(412,'Boxen','30.6.2021','17:00','60322','Frankfurt am Main','Eschersheimer Landstraße','93',999,0,'jona1',50.12459529538843,8.674722611904144),(413,'Aerobic','24.6.2021','19:57','78247','Siegen','L 190','',12,0,'jona1',47.754097979680026,8.7890625),(414,'Baseball','25.6.2021','19:59','74722','Buchen (Odenwald)','Am Weinberg','16',999,0,'jona1',49.516906273168225,9.284799098968506),(415,'Beachvolleyball','30.6.2021','13:00','65553','Limburg a. d. Lahn','Fredrick-Reilly-Straße','4',999,0,'jona1',50.40201453786945,8.08617353439331),(416,'Boxen','29.6.2021','18:00','60313','Frankfurt am Main','Zeil','Bienenkorbhaus',3,0,'jona1',50.11428335216063,8.685647249221802),(417,'Aerobic','18.6.2021','21:32','63179','Obertshausen','Berliner Straße','25',999,0,'jona1',50.06727880257515,8.842620849609375),(418,'Aerobic','22.6.2021','23:14','38700','Braunlage','Am Schultal','1A',2,0,'jona1',51.7262140716752,10.608766973018646),(419,'Aerobic','22.6.2021','20:15','99735','Mozarthausen','Schulstraße','27',999,0,'jona1',51.503625478699114,10.719837248325348),(420,'Aerobic','5.6.2021','20:15','60325','Frankfurt am Main','Bockenheimer Warte','12',2,0,'jona1',50.120084523480536,8.65086168050766),(421,'Aerobic','22.6.2021','21:16','60313','Frankfurt am Main','Opernplatz','1',999,0,'jona1',50.116054908020885,8.672026991844177),(422,'Snowboarden','24.11.2021','22:22','83317','Teisendorf','Bahnhofstraße','Friedhof',999,5,'Schatzmeister3',47.85021078107466,12.824708819389343),(425,'Hockey','19.10.2021','18:31','16321','','Rüsternstraße','15',999,0,'Schatzmeister3',52.698383182120466,13.658266961574554),(426,'null','null','null','61476','Kronberg im Taunus','Hainstraße','25',999,10,'johannes',0,0);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participate_on`
--

DROP TABLE IF EXISTS `participate_on`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participate_on` (
  `username` varchar(30) DEFAULT NULL,
  `eventid` int(11) DEFAULT NULL,
  KEY `username` (`username`),
  KEY `eventid` (`eventid`),
  CONSTRAINT `participate_on_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `participate_on_ibfk_2` FOREIGN KEY (`eventid`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participate_on`
--

LOCK TABLES `participate_on` WRITE;
/*!40000 ALTER TABLE `participate_on` DISABLE KEYS */;
INSERT INTO `participate_on` VALUES ('jona1',400),('jona1',416),('jona1',417),('jona1',418),('jona1',419),('jona1',420),('jona1',421),('Schatzmeister3',422),('Schatzmeister3',425),('johannes',410),('johannes',426);
/*!40000 ALTER TABLE `participate_on` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `vorname` varchar(30) DEFAULT NULL,
  `nachname` varchar(30) DEFAULT NULL,
  `geschlecht` char(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `passwort` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `Unique_user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('BimmelStahl','John','Stahl','','hallomeinnameistjohn@gmail.com','70b6d7535321a91f09344bb3f0caa81139271fc7cb661fa475e31960ad4cd5bf25f6ceb5386b822b93ef58ededc4f511ac890e3b95cb06202ac81a4629760b8b'),('johannes','Johannes','Jo','','johannes.jobst@stud.fra-uas.de','e7ee38a3fd191ebcfc1ef3581b2532d1b71192d1822becd37102c7a47c66619022c473f3db1fd65188c99a94eae57a645b15fee03373867a228379e1d39f55c0'),('jona1','jonathan','rodriguez','M','jona489@hotmail.de','4de1aca54d43c57620a74bfe722567b4e321b0c85f62190820a97d351e2f47441254dff50a9a682e4855c5b56f226af2f5932c7c883613c8a4f1b9874b3458db'),('jona489','jonatan','Martinez','M','jona@yahoo.de','makiisteinlauch'),('jonjon','jona','müller','W','jon@outlook.de','fc50be76b285c0f066c01434c9089002c2342a5fdfaa9dd8edc4f40665b12235a08c8ab541e09948ccd0ab6fcaa72a5858e4c94b2b8aa3ba16ac1f7688eb74b1'),('MariaUrukhai','Maria','Bilorie','W','mrsMaria11@yahoo.de','79c8eca8be03b40de1d1c51f06ad312984101b8e6654d5463a19432a5715e99f7d821af350be380842910cd2e3e526ec27325f1cd63c207a4a6a58fbbcbf5e55'),('max','Gilbert','Mustermann','','mail@mail.de','fdd9d2def3475e1d5cc87107b87e14fd6adbca664c2874fc379a1e53931c042873ad3216007f0c114b7a911eab59e60d88dbd5c2a36b9c1974766e810e1bc17a'),('max1','Max','Musterman','M','khfakh@shgksr.de','038cd71a4ca05c62f2ced71e4c70ba2001fdc323a73f26af77ab67673161000e6b0afc09318daab468e8dda7272a77316d7647f400e20c1405f904185ed23ff7'),('McLovin','Simon','Wenzel','W','simonwenzel@gmail.com','94cafab5e20935709c54d45f225819a15a07ea135602b03ccd97551141cfdc026dfbfb6a7d324e61f4c073788e43b8931016b4486627250bb2431cf622a96caa'),('MiguelMetropolis','Miguel','Metro','M','miguel33@yahoo.com','2ab106a6001acfeede61636117c3a4fc88d636be63593a57cab08d6ee393844a09e43d7e5c65c1680b5ff7f87210dc950380ba041931505ca80c1cb7963e6a22'),('MrSlave44','Richard','Stolz','X','richiplayer43@hotmail.de','a9e8fbbddbbc489dd480ae82f98b6dcf72bec63c062fe1956a49631d6c0dfe98db90f71300262570c11913974aea0439205ae2d3602eece84a7131db1018553d'),('Schatzmeister3','Heiko','Bilge','M','makisushi@live.de','6deb41893b00a0f0f6aeadee9035fb22ae8928809bbed584e4006e147c12d98df50437942bd9643d12f3654e1f922f32ed86ca65ca688bb882711fd43c7444e7'),('SibilleStein32','Sibille','Stein','W','sibillestein32@gmail.com','583603093a1446a1d99ea20b94e9ae1b8a3ffa9e75138f4d54df293e5d7554a0aa9bdd0bc7a8604f89fb6e70b7d534e68789519e344a96cdb8202c9dc78b1fdd');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-29  9:34:02
