-- ######################################################################################@
-- suppression des precedentes valeurs entrees dans la base de donnees

DELETE FROM `Utilisateur`;
DELETE FROM `TypeUtilisateur`;
DELETE FROM `Operations`;
DELETE FROM `Domaines`;
DELETE FROM `Themes`;
DELETE FROM `SousThemes`;
DELETE FROM `Formation`;
DELETE FROM `TestPrerequis`;
DELETE FROM `ValidationTest`;
DELETE FROM `Salle`;
DELETE FROM `Session`;
DELETE FROM `CheckLogistic`;
DELETE FROM `Inscription`;
DELETE FROM `Emargements`;
DELETE FROM `Evaluation`;
DELETE FROM `Alerte`;
DELETE FROM `AttribSalle`;

-- Domaines
INSERT INTO Domaines (codeDom, nom,`description`) 
VALUES('DINF00001', 'Technologies Informatiques', 'Domaine traitant des principales technologies informatiques existantes à ce jour' );

INSERT INTO Domaines (codeDom, nom,`description`) 
VALUES('DINF00002', 'Gouvernance Informatiques', 'Domaine traitant du management, la stratégie et les gestion des projets TIC' );

INSERT INTO Domaines (codeDom, nom,`description`) 
VALUES('DINF00003', 'Gouvernance Informatiques', 'Domaine traitant du management, la stratégie et les gestion des projets TIC' );

-- Themes
INSERT INTO Themes (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00001','Les frameworks web', 'Apprendre à développer des application web complètes... Dev FULLSTACK', 1);

INSERT INTO Themes (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00002','Devops, Industrialisation et gestion de la production', 'Formations DevOps, industrialisation et gestion de la production', 2);

INSERT INTO Themes (codeTheme, nom,`description`, idDomaine) 
VALUES('TINF00003','Cloud computing', 'Formations Cloud computing', 3);

-- SousThemes
INSERT INTO SousThemes (codeSthem, nom,`description`, idTheme) 
VALUES('STINF00001', 'Création de sites web', 'Formations Création de sites web', 1);

INSERT INTO SousThemes (codeSthem, nom,`description`, idTheme) 
VALUES('STINF00002', 'Intégration et déploiement continue', 'Formations Intégration continue', 2);

INSERT INTO SousThemes (codeSthem, nom,`description`, idTheme) 
VALUES('STINF00003', 'Amazon Web Services', 'Formations Amazon Web Services', 3);

-- TypeUtilisateur
INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('Administrateur', "Administrateur de l'application");

INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('RESPONSABLE CATALOGUE', 'Responsable du catalogue de formation');

INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('RESPONSABLE FORMATION', "Responsable de la planification des formation et de l'attribution des salles");

INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('RESPONSABLE LOGISTIQUE', "Responsable de la logistique, mise à disposition et préparation des salles et outils");

INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('APPRENANT', "Client devant consommer des produits ou formations du site");

INSERT INTO TypeUtilisateur (nom, `description`) 
VALUES ('FORMATEUR', "Intervenant devant animer des formations");

-- Utilisateur
INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0001', 'sado', 'frazer','','frazer@frazer.fr',NULL,'','','','ACTIVE','sadofrazer','ittraining@123', 'IT TRAINING', 1);

INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0002', 'Michel', 'Bouari','','michel@michel.com',NULL,'','','','ACTIVE','b.michel','michel@123', 'IT TRAINING', 2);

INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0003', 'Guillaume', 'TSAGUE','','tsague@tsague.net',NULL,'','','','ACTIVE','t.guillaume','guillaume@123', 'IT TRAINING', 3);

INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0004', 'jean', 'LAPORTE','','jean@jean.cm',NULL,'','','','ACTIVE','l.jean','jean@123', 'IT TRAINING', 4);

INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0005', 'Mathieu', 'NGASSA','+331789900','test@test.com',STR_TO_DATE('10-May-2005', '%d-%M-%Y'),'244434555','','BAC +2','ACTIVE','n.mathieu','mathieu@123', 'GLOB CONSULTING', 5);

INSERT INTO Utilisateur (codeUser, nom, prenom, telephone, email, dateNaiss, numeroSiret, certifications, dernierDiplome,
statut, `login`, `password`, societe, idTypeUser) 
VALUES ('USER0006', 'Etienne', 'CASSIN','','etienne@etienne.com',NULL,'','','JAVA Certified','ACTIVE','c.etienne','etienne@123', 'Dreams', 6);

-- Formation
INSERT INTO Formation (codeFormation, nom,`description`, idStheme, idRespCat) 
VALUES("FOR00001", "Conception d'interfaces graphiques full JavaScript avec Angular, TypeScript et Bootstrap",
"Formation Conception d'interfaces graphiques full JavaScript avec Angular, TypeScript et Bootstrap", 1, 2);

INSERT INTO Formation (codeFormation, nom,`description`, idStheme, idRespCat) 
VALUES("FOR00002", "Gitlab CI/CD",
"Bien démarrer sur la plate-forme DevOps complète GitLab", 2, 2);

INSERT INTO Formation (codeFormation, nom,`description`, idStheme, idRespCat) 
VALUES("FOR00003", "Amazon Web Services (AWS) - Architecture avancé",
"Amazon Web Services (AWS) - Architecture avancée; Concevoir des solutions complexes" , 3, 2);

-- Salle
INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut) 
VALUES ('NTE0001', 'NANTES', 'LA BEAUJOIRE', 12, 'RESERVED');

INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut) 
VALUES ('NTE0002', 'NANTES', 'ATLANTIS', 10, 'RESERVED');

INSERT INTO Salle (codeSalle, adresse, nomSalle, nbrePlaces, statut) 
VALUES ('NTE0003', 'NANTES', 'MANGIN', 4, 'FREE');

-- Session
INSERT INTO `Session` (codeSession, nom, `description`, statut, `type`, dateDebut, dateFin, prix, idRespFor, idFormateur, idFormation)
VALUES ('SESS00001','FORMATION DEVELOPPEMENT WEB ','SESSION DE FORMATION SUR LE DEVELOPPEMENT WEB DE FIN MAI', 
'PLAN', 'INTER', STR_TO_DATE('25-May-2022', '%d-%M-%Y'), STR_TO_DATE('31-May-2022', '%d-%M-%Y'), 2395, 3, 6, 1);

-- AttribSalle
INSERT INTO AttribSalle (dateAttrib, statut, idSession, idSalle, idRespFor) 
VALUES (STR_TO_DATE('22-May-2022', '%d-%M-%Y'),'ACTIVE', 1, 1, 3);

-- CheckLogistic
INSERT INTO CheckLogistic (codeCheck, salleIsOk, toolsIsOk, commentaires, idRespLog, idSession) 
VALUES ('CHK00001', false, false, "Check Pas encore réalisé",4, 1);

-- Inscription
INSERT INTO Inscription (codeInscription, statut, dateInscription, idApprenant, idSession) 
VALUES('INS00001', 'NEW', STR_TO_DATE('15-May-2022', '%d-%M-%Y'), 5, 1);

-- Emargements
INSERT INTO Emargements (codeEmarg, nom, periode, statut, dateSign, presenceIsOk, idInscription) 
VALUES('SIGN00001', 'SIGNATURE MATIN SESS00001', 'MATIN', 'NEW', NULL, false, 1);
INSERT INTO Emargements (codeEmarg, nom, periode, statut, dateSign, presenceIsOk, idInscription) 
VALUES('SIGN00001', 'SIGNATURE SOIR SESS00001', 'SOIR', 'NEW', NULL, false, 1);

-- Evaluations
INSERT INTO Evaluation (codeEval, nom, `description`, dateEval, statut, evalIsOk, idInscription) 
VALUES('EVAL00001','EVALUATION SESS00001','EVALUATION SESS00001',NULL, 'NEW', false, 1);