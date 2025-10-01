-- Table personnes
CREATE TABLE personnes (
    id CHAR(36) PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    datedenaissance DATE,
    ville VARCHAR(100),
    nombreEnfants INT,
    investissement VARCHAR(100),
    placement VARCHAR(100),
    situation_familiale VARCHAR(50),
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    score INT
);

-- Table professionnels
CREATE TABLE professionnels (
    id CHAR(36) NOT NULL,
    revenu DECIMAL(10,2),
    immatriculationfiscale VARCHAR(100),
    secteuractivite VARCHAR(100),
    activite VARCHAR(100),
    CONSTRAINT fk_professionnel_personne FOREIGN KEY (id) REFERENCES personnes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Table employes
CREATE TABLE employes (
    id CHAR(36) NOT NULL,
    salaire DECIMAL(10,2),
    anciennete DATE,
    poste VARCHAR(100),
    typecontrat VARCHAR(50),
    secteur VARCHAR(50),
    CONSTRAINT fk_employe_personne FOREIGN KEY (id) REFERENCES personnes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Table credits
CREATE TABLE credits (
    id CHAR(36) PRIMARY KEY,
    idpersonne CHAR(36) NOT NULL,
    dateDeCredit DATE,
    montantDemande DOUBLE,
    montantOctroye DOUBLE,
    tauxInteret DECIMAL(5,2),
    dureeEnMois INT,
    typeCredit VARCHAR(50),
    decision ENUM('ACCORD_IMMEDIAT','ETUDE_MANUELLE','REFUS_AUTOMATIQUE'),
    CONSTRAINT fk_credit_personne FOREIGN KEY (idpersonne) REFERENCES personnes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Table echeances
CREATE TABLE echeances (
    id CHAR(36) PRIMARY KEY,
    idcredit CHAR(36) NOT NULL,
    dateecheance DATE NOT NULL,
    mensualite DECIMAL(10,2),
    datedepaiement DATE,
    statutpaiement ENUM('PAYEATEMPS','IMPAYENONREGLE','PAYEENRETARD','IMPAYEREGLE'),
    CONSTRAINT fk_credit_echeance FOREIGN KEY (idcredit) REFERENCES credits(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Table incidents
CREATE TABLE incidents (
    id CHAR(36) PRIMARY KEY,
    idecheance CHAR(36) NOT NULL,
    dateIncident DATE,
    echeance VARCHAR(100),
    score INT,
    typeincident ENUM('PAYEATEMPS','ENRETARD','PAYEENRETARD','IMPAYENONREGLE','IMPAYEREGLE'),
    CONSTRAINT fk_incident_echeance FOREIGN KEY (idecheance) REFERENCES echeances(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


--procedure  insertion  employe

DELIMITER $$

CREATE PROCEDURE insert_employe (
    IN p_id CHAR(36),
    IN p_nom VARCHAR(100),
    IN p_prenom VARCHAR(100),
    IN p_datedenaissance DATE,
    IN p_ville VARCHAR(100),
    IN p_nombreEnfants INT,
    IN p_investissement VARCHAR(100),
    IN p_placement VARCHAR(100),
    IN p_situation_familiale VARCHAR(50),
    IN p_score INT,
    IN p_salaire DECIMAL(10,2),
    IN p_anciennete DATE,
    IN p_poste VARCHAR(100),
    IN p_typecontrat VARCHAR(50),
    IN p_secteur VARCHAR(50)
)
BEGIN
    INSERT INTO persones (
        id, nom, prenom, datedenaissance, ville, nombreEnfants,
        investissement, placement, situation_familiale, score
    ) VALUES (
        p_id, p_nom, p_prenom, p_datedenaissance, p_ville, p_nombreEnfants,
        p_investissement, p_placement, p_situation_familiale, p_score
    );
    INSERT INTO employes (
        id, salaire, anciennete, poste, typecontrat, secteur
    ) VALUES (
        p_id, p_salaire, p_anciennete, p_poste, p_typecontrat, p_secteur
    );
END$$

DELIMITER ;

-- procedure  insertion   professinnel
DELIMITER $$

CREATE PROCEDURE insert_personne_professionnel (
    IN v_id char(36),

    IN p_nom VARCHAR(100),
    IN p_prenom VARCHAR(100),
    IN p_datedenaissance DATE,
    IN p_ville VARCHAR(100),
    IN p_nombreEnfants INT,
    IN p_investissement VARCHAR(100),
    IN p_placement VARCHAR(100),
    IN p_situation_familiale VARCHAR(50),
    IN p_score INT,
    IN p_revenu DECIMAL(10,2),
    IN p_immatriculationfiscale VARCHAR(100),
    IN p_secteuractivite VARCHAR(100),
    IN p_activite VARCHAR(100)
)
BEGIN
    INSERT INTO persones (
        id, nom, prenom, datedenaissance, ville, nombreEnfants,
        investissement, placement, situation_familiale, score
    ) VALUES (
        v_id, p_nom, p_prenom, p_datedenaissance, p_ville, p_nombreEnfants,
        p_investissement, p_placement, p_situation_familiale, p_score
    );
    INSERT INTO professionnels (
        id, revenu, immatriculationfiscale, secteuractivite, activite
    ) VALUES (
        v_id, p_revenu, p_immatriculationfiscale, p_secteuractivite, p_activite
    );
END$$

DELIMITER ;



