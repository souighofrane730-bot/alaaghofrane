-- Nettoyage complet
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE photos_bien;
TRUNCATE TABLE visites;
TRUNCATE TABLE biens;
TRUNCATE TABLE clients;
TRUNCATE TABLE agents;
SET FOREIGN_KEY_CHECKS = 1;

-- Agents
INSERT INTO agents (id, nom, prenom, email, telephone, numero_licence, actif) VALUES 
(1, 'Ben Ali', 'Ahmed', 'ahmed.benali@agence.tn', '+216 55 123 456', 'LIC-001', 1),
(2, 'Trabelsi', 'Mouna', 'mouna.trabelsi@agence.tn', '+216 22 987 654', 'LIC-002', 1),
(3, 'Gharbi', 'Sami', 'sami.gharbi@agence.tn', '+216 98 456 123', 'LIC-003', 1)
ON DUPLICATE KEY UPDATE email=VALUES(email), nom=VALUES(nom), prenom=VALUES(prenom), telephone=VALUES(telephone);

-- Clients
INSERT INTO clients (id, nom, prenom, email, telephone, type_client, budget) VALUES
(1, 'Mansour', 'Youssef', 'youssef.mansour@mail.tn', '+216 50 111 222', 'ACHETEUR', 250000.00),
(2, 'Jelassi', 'Amira', 'amira.jelassi@mail.tn', '+216 21 333 444', 'LOCATAIRE', 1200.00),
(3, 'Bouazizi', 'Karim', 'karim.bouazizi@mail.tn', '+216 99 555 666', 'LES_DEUX', 300000.00),
(4, 'Khmiri', 'Ines', 'ines.khmiri@mail.tn', '+216 52 777 888', 'ACHETEUR', 180000.00),
(5, 'Zouari', 'Nabil', 'nabil.zouari@mail.tn', '+216 29 999 000', 'LOCATAIRE', 850.00)
ON DUPLICATE KEY UPDATE email=VALUES(email), nom=VALUES(nom), prenom=VALUES(prenom), telephone=VALUES(telephone);

-- Biens
INSERT INTO biens (id, reference, type, titre, description, surface, nb_pieces, prix, ville, quartier, adresse, code_postal, statut, type_transaction, agent_id) VALUES
(1, 'REF-001', 'APPARTEMENT', 'Bel appartement lumineux', 'Superbe appartement 3 pièces proche centre-ville...', 65.5, 3, 210000.00, 'Tunis', 'Lafayette', '12 rue de Palestine', '1002', 'PUBLIE', 'VENTE', 1),
(2, 'REF-002', 'MAISON', 'Maison familiale avec jardin', 'Grande maison 5 pièces avec beau jardin de 500m²...', 120.0, 5, 350000.00, 'Sousse', 'Sahloul', '45 avenue Yasser Arafat', '4054', 'PUBLIE', 'VENTE', 2),
(3, 'REF-003', 'APPARTEMENT', 'Studio étudiant meublé', 'Idéal étudiant, proche fac...', 22.0, 1, 650.00, 'Sfax', 'Route El Ain', '8 rue des Etudiants', '3000', 'PUBLIE', 'LOCATION', 3),
(4, 'REF-004', 'BUREAU', 'Locaux professionnels', 'Bureaux open space 100m²...', 100.0, 4, 1500.00, 'Ariana', 'Ennasr 2', '10 avenue Hedi Nouira', '2037', 'LOUE', 'LOCATION', 1),
(5, 'REF-005', 'TERRAIN', 'Terrain constructible', 'Terrain viabilisé 800m²...', 800.0, 0, 95000.00, 'Nabeul', 'Hammamet', 'Chemin des vergers', '8050', 'PUBLIE', 'VENTE', 2),
(6, 'REF-006', 'APPARTEMENT', 'T2 centre-ville', 'T2 refait à neuf...', 45.0, 2, 800.00, 'Bizerte', 'Corniche', 'Place de la résistance', '7000', 'BROUILLON', 'LOCATION', 3),
(7, 'REF-007', 'MAISON', 'Villa avec piscine', 'Magnifique villa...', 180.0, 6, 850000.00, 'Tunis', 'Carthage', 'Avenue Habib Bourguiba', '2016', 'PUBLIE', 'VENTE', 1),
(8, 'REF-008', 'APPARTEMENT', 'Duplex vue mer', 'Duplex dernier étage...', 90.0, 4, 450000.00, 'Sousse', 'Kantaoui', 'Avenue de la Mer', '4089', 'SOUS_COMPROMIS', 'VENTE', 2),
(9, 'REF-009', 'COMMERCE', 'Boutique rue passante', 'Local commercial...', 60.0, 2, 2000.00, 'Tunis', 'Centre Ville', 'Rue Charles de Gaulle', '1000', 'ARCHIVE', 'LOCATION', 3),
(10, 'REF-010', 'MAISON', 'Maison de campagne', 'A rénover...', 110.0, 4, 120000.00, 'Beja', 'Périphérie', 'Route de Testour', '9000', 'PUBLIE', 'VENTE', 1),
(11, 'REF-011', 'APPARTEMENT', 'Grand T4 familial', 'Proche écoles...', 85.0, 4, 1100.00, 'Ariana', 'Menzah 5', 'Route de l''Ariana', '2091', 'PUBLIE', 'LOCATION', 2),
(12, 'REF-012', 'APPARTEMENT', 'Loft atypique', 'Ancien atelier...', 130.0, 3, 520000.00, 'Tunis', 'La Marsa', 'Place du Saf Saf', '2070', 'PUBLIE', 'VENTE', 3),
(13, 'REF-013', 'TERRAIN', 'Terrain agricole', 'Terrain non constructible...', 5000.0, 0, 15000.00, 'Zaghouan', 'Campagne', 'Lieu dit Sidi Zid', '1100', 'PUBLIE', 'VENTE', 1),
(14, 'REF-014', 'BUREAU', 'Petit bureau partagé', 'Espace coworking...', 15.0, 1, 350.00, 'Sfax', 'Centre', 'Avenue Majida Boulila', '3000', 'LOUE', 'LOCATION', 2),
(15, 'REF-015', 'MAISON', 'Pavillon récent', 'Maison moderne...', 105.0, 5, 280000.00, 'Monastir', 'Skanes', 'Avenue de l''Environnement', '5000', 'VENDU', 'VENTE', 3),
(16, 'REF-016', 'MAISON', 'Superbe Maison Tunisienne', 'Maison de maître avec architecture typique...', 200.0, 6, 850000.00, 'Tunis', 'Sidi Bou Said', 'Rue Dar El Jeld', '2026', 'PUBLIE', 'VENTE', 1),
(17, 'REF-017', 'COMMERCE', 'Local commercial au Lac 2', 'Local spacieux et moderne pour tout commerce...', 150.0, 2, 4500.00, 'Tunis', 'Lac 2', 'Avenue de la Bourse', '1053', 'PUBLIE', 'LOCATION', 2),
(18, 'REF-018', 'BUREAU', 'Espace de bureau équipé', 'Bureaux lumineux au centre des affaires...', 120.0, 5, 2500.00, 'Sfax', 'Sfax El Jedida', 'Avenue Habib Bourguiba', '3000', 'PUBLIE', 'LOCATION', 3),
(19, 'REF-019', 'TERRAIN', 'Grand Terrain Industriel', 'Terrain pour usine ou dépôt...', 10000.0, 0, 850000.00, 'Ben Arous', 'Zone Industrielle', 'Route de Mornag', '2013', 'PUBLIE', 'VENTE', 1),
(20, 'REF-020', 'TERRAIN', 'Terrain loti pour habitation', 'Excellent terrain constructible pour villa...', 500.0, 0, 120000.00, 'Ariana', 'Soukra', 'Avenue de l''U.M.A', '2036', 'PUBLIE', 'VENTE', 2),
(21, 'REF-021', 'MAISON', 'Demeure Traditionnelle de Charme', 'Magnifique Dar authentique au coeur de la Medina, patio central et architecture traditionnelle...', 350.0, 8, 950000.00, 'Tunis', 'Medina', 'Rue de la Kasbah', '1006', 'PUBLIE', 'VENTE', 3),
(22, 'REF-022', 'TERRAIN', 'Terrain Agricole avec Oliviers', 'Terrain de 2 hectares avec plus de 200 pieds d''oliviers productifs...', 20000.0, 0, 180000.00, 'Beja', 'Testour', 'Route du Verger', '9000', 'PUBLIE', 'VENTE', 1)
ON DUPLICATE KEY UPDATE ville=VALUES(ville), quartier=VALUES(quartier), adresse=VALUES(adresse), titre=VALUES(titre);

INSERT INTO photos_bien (bien_id, url, ordre, principale) VALUES
-- APPARTEMENT (ID 1)
(1, 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=800', 1, 1),
(1, 'https://images.unsplash.com/photo-1484154218962-a197022b5858?w=800', 2, 0),
(1, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=800', 3, 0),
-- MAISON (ID 2)
(2, 'https://images.unsplash.com/photo-1568605114967-8130f3a36994?w=800', 1, 1),
(2, 'https://images.unsplash.com/photo-1583608205776-bfd35f0d9f83?w=800', 2, 0),
(2, 'https://images.unsplash.com/photo-1570129477492-45c003edd2be?w=800', 3, 0),
-- APPARTEMENT (ID 3)
(3, 'https://images.unsplash.com/photo-1554995207-c18c203602cb?w=800', 1, 1),
(3, 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?w=800', 2, 0),
(3, 'https://images.unsplash.com/photo-1527030280862-64139fba04ca?w=800', 3, 0),
-- BUREAU (ID 4)
(4, 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=800', 1, 1),
(4, 'https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=800', 2, 0),
(4, 'https://images.unsplash.com/photo-1556761175-5973dc0f32b7?w=800', 3, 0),
-- TERRAIN CONSTRUCTIBLE (ID 5)
(5, 'https://images.unsplash.com/photo-1599933334293-b097cc0f6990?w=800', 1, 1),
(5, 'https://images.unsplash.com/photo-1591955506264-3f5a6834570a?w=800', 2, 0),
(5, 'https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800', 3, 0),
-- APPARTEMENT (ID 6)
(6, 'https://images.unsplash.com/photo-1493809842364-78817add7ffb?w=800', 1, 1),
(6, 'https://images.unsplash.com/photo-1515263487990-61b07816b324?w=800', 2, 0),
(6, 'https://images.unsplash.com/photo-1505691938895-1758d7eaa511?w=800', 3, 0),
-- MAISON VILLA (ID 7)
(7, 'https://images.unsplash.com/photo-1613490493576-7fde63acd811?w=800', 1, 1),
(7, 'https://images.unsplash.com/photo-1613977257363-707ba9348227?w=800', 2, 0),
(7, 'https://images.unsplash.com/photo-1600566753190-17f0baa2a6c3?w=800', 3, 0),
-- APPARTEMENT (ID 8)
(8, 'https://images.unsplash.com/photo-1512918728675-ed5a9ecdebfd?w=800', 1, 1),
(8, 'https://images.unsplash.com/photo-1512914890251-2f96a9b0bbb2?w=800', 2, 0),
(8, 'https://images.unsplash.com/photo-1536376074432-cd2926713871?w=800', 3, 0),
-- COMMERCE (ID 9)
(9, 'https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=800', 1, 1),
(9, 'https://images.unsplash.com/photo-1472851294608-062f824d28c5?w=800', 2, 0),
(9, 'https://images.unsplash.com/photo-1534452203294-49c8913721b2?w=800', 3, 0),
-- MAISON CAMPAGNE (ID 10)
(10, 'https://images.unsplash.com/photo-1510798831971-661eb04b3739?w=800', 1, 1),
(10, 'https://images.unsplash.com/photo-1472233501404-50768e2a392c?w=800', 2, 0),
(10, 'https://images.unsplash.com/photo-1500315331616-db4f707c24d1?w=800', 3, 0),
-- APPARTEMENT (ID 11)
(11, 'https://images.unsplash.com/photo-1522771739844-6a9f6d5f14af?w=800', 1, 1),
(11, 'https://images.unsplash.com/photo-1502672590031-f200968a6e72?w=800', 2, 0),
(11, 'https://images.unsplash.com/photo-1560185127-6ed189bf02f4?w=800', 3, 0),
-- LOFT ATYPIQUE (ID 12)
(12, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=800', 1, 1),
(12, 'https://images.unsplash.com/photo-1534438327276-14e5300c3a48?w=800', 2, 0),
(12, 'https://images.unsplash.com/photo-1502005229762-f1ba5adad80f?w=800', 3, 0),
-- TERRAIN AGRICOLE (ID 13)
(13, 'https://images.unsplash.com/photo-1467043237213-65f2da53396f?w=800', 1, 1),
(13, 'https://images.unsplash.com/photo-1541336528065-8f1fdc435835?w=800', 2, 0),
(13, 'https://images.unsplash.com/photo-1505230833350-090c883709b3?w=800', 3, 0),
-- BUREAU PARTAGE (ID 14)
(14, 'https://images.unsplash.com/photo-1497215842964-222b430dc094?w=800', 1, 1),
(14, 'https://images.unsplash.com/photo-1504384308090-c894fdcc538d?w=800', 2, 0),
(14, 'https://images.unsplash.com/photo-1519389950473-47ba0277781c?w=800', 3, 0),
-- MAISON MODERNE (ID 15)
(15, 'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?w=800', 1, 1),
(15, 'https://images.unsplash.com/photo-1600585154340-be6199f7d009?w=800', 2, 0),
(15, 'https://images.unsplash.com/photo-1600047509807-ba8f99d2cdde?w=800', 3, 0),
-- MAISON TRADITIONNELLE (ID 16)
(16, 'https://images.unsplash.com/photo-1590725150739-16789708683b?w=800', 1, 1),
(16, 'https://images.unsplash.com/photo-1564501049412-61c2a3083791?w=800', 2, 0),
(16, 'https://images.unsplash.com/photo-1541480601022-23057d163484?w=800', 3, 0),
-- LOCAL LAC 2 (ID 17)
(17, 'https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=800', 1, 1),
(17, 'https://images.unsplash.com/photo-1472851294608-062f824d28c5?w=800', 2, 0),
(17, 'https://images.unsplash.com/photo-1534452203294-49c8913721b2?w=800', 3, 0),
-- BUREAU EQUIPE (ID 18)
(18, 'https://images.unsplash.com/photo-1556761175-4b46a572b786?w=800', 1, 1),
(18, 'https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=800', 2, 0),
(18, 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=800', 3, 0),
-- TERRAIN INDUSTRIEL (ID 19)
(19, 'https://images.unsplash.com/photo-1590247813693-5541d1c609fd?w=800', 1, 1),
(19, 'https://images.unsplash.com/photo-1586528116311-ad8dd3c8310d?w=800', 2, 0),
(19, 'https://images.unsplash.com/photo-1504917595217-d4dc5ebe6122?w=800', 3, 0),
-- TERRAIN LOTI (ID 20)
(20, 'https://images.unsplash.com/photo-1531834685032-c34bf0d84c77?w=800', 1, 1),
(20, 'https://images.unsplash.com/photo-1625244724120-1fd1d34d00f6?w=800', 2, 0),
(20, 'https://images.unsplash.com/photo-1596720426673-e483d744d00a?w=800', 3, 0),
-- DAR TRADITIONNELLE (ID 21)
(21, 'https://images.unsplash.com/photo-1600607687939-ce8a6c25118c?w=800', 1, 1),
(21, 'https://images.unsplash.com/photo-1590725121406-38d58521096a?w=800', 2, 0),
(21, 'https://images.unsplash.com/photo-1564501049062-15d4a09cfac3?w=800', 3, 0),
-- TERRAIN OLIVIERS (ID 22)
(22, 'https://images.unsplash.com/photo-1467043237213-65f2da53396f?w=800', 1, 1),
(22, 'https://images.unsplash.com/photo-1464226184884-fa280b87c399?w=800', 2, 0),
(22, 'https://images.unsplash.com/photo-1500917293891-ef795e70e1f6?w=800', 3, 0);

-- Visites
INSERT INTO visites (id, bien_id, client_id, agent_id, date_heure, statut, compte_rendu, impression) VALUES
(1, 1, 1, 1, '2023-10-15 14:00:00', 'REALISEE', 'Client très intéressé', 'POSITIVE'),
(2, 3, 2, 3, '2023-10-16 10:00:00', 'REALISEE', 'Un peu petit', 'NEUTRE'),
(3, 7, 3, 1, '2024-05-20 15:30:00', 'PLANIFIEE', NULL, NULL)
ON DUPLICATE KEY UPDATE statut=VALUES(statut);
