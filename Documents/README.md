# Takenoko-MFAS
Projet de developpement du semestre 1 de M1 Informatique


Résumer des milestones:

Tag1 Début d'une partie:
Nous avons dans cette milestone cree les parcelles et les bots pour faire un d�but de jeu.
Pour poser les parcelles ,on recupere la position des parcelles voisines.


Sept24: Les parcelles de types etangs
Nous avons places correctement les parcelles et nous avons mis en place les étangs pour toute les parcelles

Sept25 : Un objectif et le jardinier
Cette milestone était composé de deux slices l'introduction de l'objectif et du jardinier.
Dans l'inroduction de l'objectif nous avons crée les bambous et ensuite nous avons fait l'assignation d'un objectif
au bot.
Pour l'introduction du jardinier, nous l'avons crée et ensuite nous avons crée ses mouvements.


Sept26 : Le panda et une stratégie pour le bot
Cette milestone contient deux slices, l'introduction du panda et la stratégie du bot.
Dans l'introduction du panda nous avons crée le panda et ensuite ses mouvements.
Pour la stratégie du bot, nous avons implémenté une stratégie diffèrentes pour le bot et nous avons
rajouter l'objectif du jardinier

Oct03 : Les objctifs des pandas et la couleur des parcelles
Cette milestone contient deux slices, introduction de parcelles colorées et les objectifs du panda.
Dans l'introduction de parcelles colorées nous avons ajouté des parcelles et des bambous colorés.
Pour les objectifs du panda nous avons ajoutés differents objectifs de type panda ainsi que des pioches pour tous les objectifs.

Oct10 : Les decks, objectifs du panda et finalisation du jardinier
Cette milestone contient trois slices, Les différents decks , la realisation des objectifs panda pour le bot et
la finalisation du jardinier. Dans les différents decks, nous avons cree le deck des parcelles et la possibilite pour
le bot de piocher ces parcelles et aussi nous avons permis au bot de piocher ces objectifs dans le deck objectifs.
Pour le panda nous avons cree un bot panda et nous avons fait les verifications pour les objectifs panda soit bien realiser.
Pour finir nous avons cree le bot Jardinier et ajuster l'effet du jardinier.


Oct17 : Les objectifs parcelles et son bot
Cette milestone contient deux slices, les objectifs parcelles et le bot parcelle.Nous avons crée un deck pour les
objectifs parcelle afin que le bot puissent piocher des objectifs parcelles.Le bot parcelle pioche un objectif parcelle
où il doit réaliser le motif.

Oct24 : L'irrigation
Cette milestone contient deux slices , l'implementation du système d'irrigation et le système avancer de l'irrigation.
Nous avons crée les batonnets d'irrigation , l'irrigation sur le plateau et la pioche et la poche de l'irrigation pour le bot.
Nous avons aussi mis le choix de l'irrigation pour le bot et la vérification du réseau de l'irrigation.


Final : Finalisation
Cette milestone contient quatre slices , la correction du botParcelle, la correction des objectifs, la correction de la pioche des parcelles
et les statistiques. Nous avons modifier le botParcelle afin qu'il joue d'une meilleure manière, nous avons corrigé les objectifs afin que les bots réalisent plus d'objectifs.
Nous avons corrigés les pioches afin que cela soit exactement comme le jeu et nous avons ajoutés les 1000 parties ainsi que Spring.


Lancer les Main :
mvn exec:java@Main (C'est le Main qui lance une partie entre 3 joueurs implémentés avec Spring)
mvn exec:java@Main2 (C'est le Main qui lance 1000 parties entre les 3 joueurs)
mvn exec:java@Main3 (C'est le Main qui lance 1000 parties de notre meilleur joueur contre lui-même)

##############################TER######################

Le Main2 est celui qui run les résultats de notre IANormale contre le reste des bots.

Le Main4 est celui qui run les tests pour prouvé l'efficacité de notre IA.

