create database  scoring ;
use   scoring  ;
create  table  persones  (
id   INTEGER  PRIMARY  key   ,
name  varchar(30)   not  null,
prenom  varchar(30)   not  null ,
datedenaissance  DATE not  null,
ville VARCHAR(30)   not  null ,
nombreEnfants  int  not null  default 0 ,
investissement  varchar(40)  not  null ,
placement   varchar(40)   not  null,
situation_familiale varchar(30)  not  null ,
createdAt   DATETIME   not  null  ,
score    int  not  null
);
create   table  employes(
   id  int  primary  key  auto_increment ,
   idPersone   int  not  null unique  ,
   salaire   decimal(10,2)   not  null,
   ancienneteEnMois   int  not  null  default 0;
   poste  varchar(30)   not  ull ,
   typeContrat  enum('CDI','CDD','Profession_liberale_stable'),
   secteur   enum('public','prive_grande_entreprise','prive_PME'),
   constraint  FK_empPerson   foreign   key(idPersone)  references  persones(id)
   );