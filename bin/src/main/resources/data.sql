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

-- Photos des biens
INSERT INTO photos_bien (bien_id, url, ordre, principale) VALUES
-- APPARTEMENTs
(1, 'https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?w=800', 1, 1),
(3, 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?w=800', 1, 1),
(6, 'https://images.unsplash.com/photo-1493809842364-78817add7ffb?w=800', 1, 1),
(8, 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?w=800', 1, 1),
(11, 'https://images.unsplash.com/photo-1527030280862-64139fba04ca?w=800', 1, 1),
(12, 'https://images.unsplash.com/photo-1484154218962-a197022b5858?w=800', 1, 1),
-- MAISONs / VILLAs
(2, 'https://images.unsplash.com/photo-1600585154340-be6199f7d009?w=800', 1, 1),
(7, 'https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?w=800', 1, 1),
(10, 'https://images.unsplash.com/photo-1613977257363-707ba9348227?w=800', 1, 1),
(15, 'https://images.unsplash.com/photo-1613490493576-7fde63acd811?w=800', 1, 1),
(16, 'https://images.unsplash.com/photo-1596422846543-75c6fc18a593?w=800', 1, 1),
(21, 'https://images.unsplash.com/photo-1518780664697-55e3ad937233?w=800', 1, 1),
-- TERRAINs
(5, 'https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800', 1, 1),
(13, 'https://images.unsplash.com/photo-1599933310631-155e7f12e10c?w=800', 1, 1),
(19, 'https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=800', 1, 1),
(20, 'https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800', 1, 1),
(22, 'https://images.unsplash.com/photo-1500382017468-9049fed747ef?w=800', 1, 1),
-- BUREAU / COMMERCE
(4, 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=800', 1, 1),
(14, 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=800', 1, 1),
(18, 'https://images.unsplash.com/photo-1556761175-4b46a572b786?w=800', 1, 1),
(9, 'https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=800', 1, 1),
(17, 'https://images.unsplash.com/photo-1534452203294-49c8913721b2?w=800', 1, 1);

-- Visites
INSERT INTO visites (id, bien_id, client_id, agent_id, date_heure, statut, compte_rendu, impression) VALUES
(1, 1, 1, 1, '2023-10-15 14:00:00', 'REALISEE', 'Client très intéressé', 'POSITIVE'),
(2, 3, 2, 3, '2023-10-16 10:00:00', 'REALISEE', 'Un peu petit', 'NEUTRE'),
(3, 7, 3, 1, '2024-05-20 15:30:00', 'PLANIFIEE', NULL, NULL)
ON DUPLICATE KEY UPDATE statut=VALUES(statut);
