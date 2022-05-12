-- Suppression des contraintes 
-- ALTER TABLE Themes DROP FOREIGN KEY FK_Themes_Domaines;
-- ALTER TABLE Sous_Themes DROP FOREIGN KEY FK_SThemes_Themes;
-- ALTER TABLE Formations DROP FOREIGN KEY FK_Formation_SThemes;
-- ALTER TABLE Formations DROP FOREIGN KEY FK_Formation_Utilisateur;
-- ALTER TABLE Test_Prerequis DROP FOREIGN KEY FK_TestP_Formation;
-- ALTER TABLE Validation_Test DROP FOREIGN KEY FK_ValidTest_TestP;
-- ALTER TABLE Validation_Test DROP FOREIGN KEY FK_ValidTest_Utilisateur;
-- ALTER TABLE Utilisateur DROP FOREIGN KEY FK_Utilisateur_TypeU;
-- ALTER TABLE Operations DROP FOREIGN KEY FK_Ope_User;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_User;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_Formation;
-- ALTER TABLE `Session` DROP FOREIGN KEY FK_Session_Salle;
-- ALTER TABLE Inscription DROP FOREIGN KEY FK_Ins_Session;
-- ALTER TABLE Inscription DROP FOREIGN KEY FK_Ins_Utilisateur;
-- ALTER TABLE Check_logistic DROP FOREIGN KEY FK_Check_Utilisateur;
-- ALTER TABLE Check_logistic DROP FOREIGN KEY FK_Check_Session;
-- ALTER TABLE Emargements DROP FOREIGN KEY FK_Emarg_Inscription ;
-- ALTER TABLE Evaluation DROP FOREIGN KEY FK_Eval_Inscription;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_Inscription;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_Session ;
-- ALTER TABLE Alerte DROP FOREIGN KEY FK_Alert_User ;


-- ######################### Nouvelle Création ###########################
-- Creation de la BDD
DROP DATABASE IF EXISTS it_training_bdd;
CREATE DATABASE it_training_bdd;

use it_training_bdd;

-- Suppression des tables
-- DROP TABLE IF EXISTS Utilisateur, Type_utilisateur, Operations, Domaines, Themes, Sous_Themes, Formation, Test_Prerequis, 
-- Validation_Test, Salle, `Session`, `Check_logistic`, `Inscription`, `Emargements`, `Evaluation`, `Alerte`;

-- Creation des tables
 CREATE TABLE `Utilisateur` (
  `id_utilisateur` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `prenom` varchar(50),
  `email` varchar(20) UNIQUE not null,
  `tel` varchar(20),
  `login` varchar(20) not null,
  `password` varchar(20) not null,
  `societe` varchar(50),
  `statut` varchar(5),
  `id_type` int not null
);

CREATE TABLE `Type_utilisateur` (
  `id_type` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `description` varchar(120)
);

CREATE TABLE `Operations` (
  `id_operation` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `description` varchar(150),
  `date_debut` datetime not null,
  `id_utilisateur` int not null
);

CREATE TABLE `Domaines` (
  `id_domaine` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250)
);

CREATE TABLE `Themes` (
  `id_theme` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `id_domaine` int not null
);

CREATE TABLE `Sous_Themes` (
  `id_stheme` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `id_theme` int not null
);

CREATE TABLE `Formation` (
  `id_formation` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `id_stheme` int not null,
  `id_resp_for` int not null
);

CREATE TABLE `Test_Prerequis` (
  `id_test` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(30) not null,
  `description` varchar(250),
  `id_formation` int not null
);

CREATE TABLE `Validation_Test` (
  `id_val` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(250) not null,
  `commentaires` varchar(250),
  `resultat` numeric not null,
  `id_test` int not null,
  `id_apprenant` int not null
);

CREATE TABLE `Salle` (
  `id_salle` int PRIMARY KEY AUTO_INCREMENT,
  `adresse` varchar(50),
  `nom_salle` varchar(50) not null,
  `nbre_place` int not null,
  `statut` varchar(5) not null
);

CREATE TABLE `Session` (
  `id_session` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `statut` varchar(5) not null,
  `date_debut` date not null,
  `date_fin` date not null,
  `prix` decimal(5,2) not null,
  `id_salle` int not null,
  `id_formateur` int not null,
  `id_formation` int not null
);

CREATE TABLE `Check_logistic` (
  `id_check` int PRIMARY KEY AUTO_INCREMENT,
  `res_salle` boolean,
  `verif_outils` boolean,
  `statut` varchar(5) not null,
  `id_resp_log` int not null,
  `id_session` int not null
);

CREATE TABLE `Inscription` (
  `id_inscription` int PRIMARY KEY AUTO_INCREMENT,
  `statut` varchar(5) not null,
  `date_inscription` date not null,
  `id_apprenant` int not null,
  `id_session` int not null
);

CREATE TABLE `Emargements` (
  `id_iemargement` int PRIMARY KEY AUTO_INCREMENT,
  `periode` varchar(5) not null,
  `statut` varchar(5) not null,
  `date_sign` date,
  `etat_presence` varchar(10),
  `id_inscription` int not null
);

CREATE TABLE `Evaluation` (
  `id_eval` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `resultat` numeric,
  `statut` varchar(3) not null,
  `id_inscription` int not null
);

CREATE TABLE `Alerte` (
  `id_alerte` int PRIMARY KEY AUTO_INCREMENT,
  `gravite` varchar(5) not null,
  `statut` varchar(5) not null,
  `type` varchar(5) not null,
  `id_utilisateur` int,
  `id_session` int,
  `id_inscription` int
);

-- Creation des contraintes
ALTER TABLE Themes ADD CONSTRAINT FK_Themes_Domaines FOREIGN KEY (id_domaine) REFERENCES Domaines(id_domaine); -- ON DELETE CASCADE;
ALTER TABLE Sous_Themes ADD CONSTRAINT FK_SThemes_Themes FOREIGN KEY (id_theme) REFERENCES Themes(id_theme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_SThemes FOREIGN KEY (id_stheme) REFERENCES Sous_Themes(id_stheme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_Utilisateur FOREIGN KEY (id_resp_for) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE Test_Prerequis ADD CONSTRAINT FK_TestP_Formation FOREIGN KEY (id_formation) REFERENCES Formation(id_formation);
ALTER TABLE Validation_Test ADD CONSTRAINT FK_ValidTest_TestP FOREIGN KEY (id_test) REFERENCES Test_Prerequis(id_test);
ALTER TABLE Validation_Test ADD CONSTRAINT FK_ValidTest_Utilisateur FOREIGN KEY (id_apprenant) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE Utilisateur ADD CONSTRAINT FK_Utilisateur_TypeU FOREIGN KEY (id_type) REFERENCES Type_utilisateur(id_type);
ALTER TABLE Operations ADD CONSTRAINT FK_Ope_User FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_User FOREIGN KEY (id_formateur) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_Formation FOREIGN KEY (id_formation) REFERENCES Formation(id_formation);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_Salle FOREIGN KEY (id_salle) REFERENCES Salle(id_salle);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Session FOREIGN KEY (id_session) REFERENCES `Session`(id_session);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Utilisateur FOREIGN KEY (id_apprenant) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE Check_logistic ADD CONSTRAINT FK_Check_Utilisateur FOREIGN KEY (id_resp_log) REFERENCES Utilisateur(id_utilisateur);
ALTER TABLE Check_logistic ADD CONSTRAINT FK_Check_Session FOREIGN KEY (id_session) REFERENCES `Session`(id_session);
ALTER TABLE Emargements ADD CONSTRAINT FK_Emarg_Inscription FOREIGN KEY (id_inscription) REFERENCES Inscription(id_inscription);
ALTER TABLE Evaluation ADD CONSTRAINT FK_Eval_Inscription FOREIGN KEY (id_inscription) REFERENCES Inscription(id_inscription);
ALTER TABLE Alerte ADD CONSTRAINT FK_Alert_Inscription FOREIGN KEY (id_inscription) REFERENCES Inscription(id_inscription);
ALTER TABLE Alerte ADD CONSTRAINT FK_Alert_Session FOREIGN KEY (id_session) REFERENCES `Session`(id_session);
ALTER TABLE Alerte ADD CONSTRAINT FK_Alert_User FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur);
