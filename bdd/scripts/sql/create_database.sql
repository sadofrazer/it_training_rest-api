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
  `idUtilisateur` PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50), not Null,
  `prenom` varchar(50),
  `telephone` varchar(20),
  `email` varchar(50) UNIQUE,
  `dateNaiss` date,
  `numeroSiret` varchar(50),
  `certifications` varchar(250),
  `dernierDiplome` varchar(250),
  `login` varchar(20) not null,
  `password` varchar(20) not null,
  `societe` varchar(50),
  `idTypeUser` int noot null,
);

CREATE TABLE `TypeUtilisateur` (
  `idType` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `description` varchar(120)
);

CREATE TABLE `Operations` (
  `idOperation` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `description` varchar(150),
  `dateDebut` datetime not null,
  `idUtilisateur` int not null
);

CREATE TABLE `Domaines` (
  `idDomaine` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250)
);

CREATE TABLE `Themes` (
  `idTheme` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `idDomaine` int not null
);

CREATE TABLE `SousThemes` (
  `idStheme` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `idTheme` int not null
);

CREATE TABLE `Formation` (
  `idFormation` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `idStheme` int not null,
  `idRespFor` int not null
);

CREATE TABLE `Test_Prerequis` (
  `idTest` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(30) not null,
  `description` varchar(250),
  `idFormation` int not null
);

CREATE TABLE `ValidationTest` (
  `idVal` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(250) not null,
  `commentaires` varchar(250),
  `resultat` numeric not null,
  `idtest` int not null,
  `idapprenant` int not null
);

CREATE TABLE `Salle` (
  `idSalle` int PRIMARY KEY AUTO_INCREMENT,
  `adresse` varchar(50),
  `nomSalle` varchar(50) not null,
  `nbrePlaces` int not null,
  `statut` varchar(5) not null
);

CREATE TABLE `AttribSalle` (
  `idAttribSalle` int,
  `dateAttrib` date,
  `statut` varchar(5),
  `idSession` int not null,
  `idSalle` int not null,
  `idRespFor` int not null
);

CREATE TABLE `Session` (
  `id_session` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `statut` varchar(5) not null,
  `type` varchar(5) not null,
  `dateDebut` date not null,
  `dateFin` date not null,
  `prix` decimal(5,2),
  `idFormateur` int not null,
  `idFormation` int not null,
);

CREATE TABLE `CheckLogistic` (
  `idCheck` int not null,
  `salleIsOk` boolean not null,
  `toolsIsOk` boolean not null,
  `commentaires` varchar(250),
  `idRespLog` int not null,
  `idSession` int not null,
);

CREATE TABLE `Inscription` (
  `idInscription` int PRIMARY KEY AUTO_INCREMENT,
  `statut` varchar(5) not null,
  `dateInscription` date not null,
  `idApprenant` int not null,
  `idSession` int not null
);

CREATE TABLE `Emargements` (
  `idEmargement` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(50) not null,
  `periode` varchar(5) not null,
  `statut` varchar(5),
  `dateSign` date,
  `presenceIsOk` boolean,
  `idInscription` int not null,
);

CREATE TABLE `Evaluation ` (
  `idEval` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(120) not null,
  `description` varchar(250),
  `dateEval` date not null,
  `statut` varchar(5),
  `evalIsOk` boolean,
  `idInscription` int not null,
);

CREATE TABLE `Alerte` (
  `id_alerte` int PRIMARY KEY AUTO_INCREMENT,
  `gravite` varchar(5) not null,
  `statut` varchar(5) not null,
  `type` varchar(5) not null,
  `idUtilisateur` int,
);

-- Creation des contraintes
ALTER TABLE Themes ADD CONSTRAINT FK_Themes_Domaines FOREIGN KEY (idDomaine) REFERENCES Domaines(idDomaine); -- ON DELETE CASCADE;
ALTER TABLE Sous_Themes ADD CONSTRAINT FK_SThemes_Themes FOREIGN KEY (idTheme) REFERENCES Themes(idTheme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_SThemes FOREIGN KEY (idStheme) REFERENCES SousThemes(idStheme);
ALTER TABLE Formation ADD CONSTRAINT FK_Formation_Utilisateur FOREIGN KEY (idRespFor) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE Test_Prerequis ADD CONSTRAINT FK_TestP_Formation FOREIGN KEY (idFormation) REFERENCES Formation(idFormation);
ALTER TABLE Validation_Test ADD CONSTRAINT FK_ValidTest_TestP FOREIGN KEY (idTest) REFERENCES TestPrerequis(idTest);
ALTER TABLE Validation_Test ADD CONSTRAINT FK_ValidTest_Utilisateur FOREIGN KEY (idApprenant) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE Utilisateur ADD CONSTRAINT FK_Utilisateur_TypeU FOREIGN KEY (idType) REFERENCES TypeUtilisateur(idType);
ALTER TABLE Operations ADD CONSTRAINT FK_Ope_User FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_User FOREIGN KEY (idFormateur) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE `Session` ADD CONSTRAINT FK_Session_Formation FOREIGN KEY (idFormation) REFERENCES Formation(idFormation);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_Session FOREIGN KEY (idSession) REFERENCES Session(idSession);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_Salle FOREIGN KEY (idSalle) REFERENCES Salle(idSalle);
ALTER TABLE `AttribSalle` ADD CONSTRAINT FK_AttribS_User FOREIGN KEY (idRespFor) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Session FOREIGN KEY (idSession) REFERENCES `Session`(idSession);
ALTER TABLE Inscription ADD CONSTRAINT FK_Ins_Utilisateur FOREIGN KEY (idApprenant) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE CheckLogistic ADD CONSTRAINT FK_Check_Utilisateur FOREIGN KEY (idRespLog) REFERENCES Utilisateur(idUtilisateur);
ALTER TABLE CheckLogistic ADD CONSTRAINT FK_Check_Session FOREIGN KEY (idSession) REFERENCES `Session`(idSession);
ALTER TABLE Emargements ADD CONSTRAINT FK_Emarg_Inscription FOREIGN KEY (idInscription) REFERENCES Inscription(idInscription);
ALTER TABLE Evaluation ADD CONSTRAINT FK_Eval_Inscription FOREIGN KEY (idInscription) REFERENCES Inscription(idInscription);
ALTER TABLE Alerte ADD CONSTRAINT FK_Alert_User FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur);
