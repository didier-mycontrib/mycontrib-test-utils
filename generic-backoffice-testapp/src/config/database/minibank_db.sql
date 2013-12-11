
CREATE DATABASE IF NOT EXISTS minibank_db;
USE minibank_db;

DROP TABLE IF EXISTS Operation;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Adresse;
DROP TABLE IF EXISTS InfosAuth;



######################## CREATE  TABLE ########################################

CREATE TABLE Client(
	prenom VARCHAR(64),
	numClient integer auto_increment,
	nom VARCHAR(64),
	dateNaissance DATE,
	ref_adressePrincipale integer,
	          ref_infosAuth integer,
	PRIMARY KEY(numClient));	 

CREATE TABLE Adresse(
	codePostal VARCHAR(64),
	ville VARCHAR(64),
	rue VARCHAR(64),
	idAdr integer auto_increment,
	
	PRIMARY KEY(idAdr));	 

CREATE TABLE InfosAuth(
	password VARCHAR(64),
	idAuth integer auto_increment,
	
	PRIMARY KEY(idAuth));	 

CREATE TABLE Compte(
	label VARCHAR(64),
	numCpt integer auto_increment,
	solde double,
	ref_proprietaire integer,
	PRIMARY KEY(numCpt));	 

CREATE TABLE Operation(
	label VARCHAR(64),
	montant double,
	numOp integer auto_increment,
	dateOp DATE,
	ref_compte integer,
	PRIMARY KEY(numOp));	 



#######################   FOREIGN KEY       ####################################

ALTER TABLE Client ADD CONSTRAINT Client_avec_adressePrincipale_valide 
FOREIGN KEY (ref_adressePrincipale) REFERENCES Adresse(idAdr);
ALTER TABLE Client ADD CONSTRAINT Client_avec_infosAuth_valide 
FOREIGN KEY (ref_infosAuth) REFERENCES InfosAuth(idAuth);






ALTER TABLE Compte ADD CONSTRAINT Compte_avec_proprietaire_valide 
FOREIGN KEY (ref_proprietaire) REFERENCES Client(numClient);


ALTER TABLE Operation ADD CONSTRAINT Operation_avec_compte_valide 
FOREIGN KEY (ref_compte) REFERENCES Compte(numCpt);




#########################  INSERT INTO   #####################################

#INSERT INTO Adresse (codePostal,idAdr,rue,ville)
#              VALUES ('27950',1,'allee de S','st-Marcel');
#INSERT INTO InfosAuth (idAuth,password)
#              VALUES (1,'mypwd');
#INSERT INTO Client (dateNaissance,nom,numClient,prenom,ref_adressePrincipale,ref_infosAuth)
#              VALUES ('1969-07-11','Defrance',1,'Didier',1,1);
#INSERT INTO Compte (label,numCpt,solde,ref_proprietaire)
#              VALUES ('compte courant',1,1200.0,1);
#INSERT INTO Compte (label,numCpt,solde,ref_proprietaire)
#              VALUES ('compte codevi',2,50.0,1);               
#INSERT INTO Operation (dateOp,label,montant,numOp,ref_compte)
#              VALUES ('2011-01-20','achat yy',-50.0,1,1);


###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM Client;
SELECT * FROM Adresse;
SELECT * FROM InfosAuth;
SELECT * FROM Compte;
SELECT * FROM Operation;


