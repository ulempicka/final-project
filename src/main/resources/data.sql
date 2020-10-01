insert into category (id, category_name, category_description, category_img_url)
values (1, 'BREAKFAST', 'Pierwszy posiłek dnia, najczęściej spożywany w godzinach porannych. W zależności od tradycji narodowej składa się z różnych potraw – od
lekkich i prostych do bardziej sycących i skomplikowanych.', 'https://akademiasmaku.pl/upload/vademecums/777/big/sniadanie-kontynentalne-co-zawiera-777.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (2, 'LUNCH', 'Szybki, lekki posiłek spożywany w trakcie krótkiej przerwy obiadowej. Znaczeniowo, odpowiednik polskiej przekąski między śniadaniem a obiadem
(drugie śniadanie), spożywany najczęściej w godzinach 10–13.', 'https://i.ytimg.com/vi/hfehjjsHJaQ/maxresdefault.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (3, 'DINNER', 'Główny i zarazem najobfitszy posiłek w ciągu dnia, spożywany w Polsce najczęściej między godziną 12 a 16. Tradycyjnie składa się z dwóch dań –
w Polsce zwykle z zupy oraz dania głównego.', 'https://3.bp.blogspot.com/-IZhMRAakrxM/WvHkD4ylFcI/AAAAAAAAEUs/8PjYVWdqws0XmPpXLl4qcVi73W1p598SgCLcBGAs/s1600/DSC_1880.JPG');
insert into category (id, category_name, category_description, category_img_url)
values (4, 'SUPPER', 'Ostatni posiłek wieczorny. W Polsce i w innych krajach europejskich kolację je się zazwyczaj w godzinach 18-21.', 'https://s3.przepisy.pl/przepisy3ii/img/variants/1070x0/191511-2.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (5, 'DESSERT', 'Potrawa podawana jako osobne słodkie danie na koniec posiłku (obiadu, kolacji lub przyjęcia), ale także na podwieczorek albo podczas
niezobowiązującego spotkania o dowolnej porze dnia.', 'https://pysznosci.pl/wp-content/uploads/2020/03/deser-neapolitanski-mini.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (6, 'SOUP', 'Płynna lub półpłynna potrawa mająca zazwyczaj postać wywaru powstającego podczas gotowania różnorodnych składników. W tradycji polskiej zupa jest
zwykle pierwszym daniem obiadu.', 'https://s3.przepisy.pl/przepisy3ii/img/variants/767x0/rosol_z_kury170242.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (7, 'MAIN', 'Jako dania główne oznaczamy posiłki sycące, spożywane o określonych porach dnia - śniadanie, obiad (lunch) i kolacja czy obiadokolacja.
Różnorodność dań, sposobu przyrządzania, użytych składników jest ogromna.', 'https://cdn.katalogsmakow.pl/2018/08/19/0x600/carska-uczta-z-lopatki-pomysl-na-obiad.729506.jpg');
insert into category (id, category_name, category_description, category_img_url)
values (8, 'FIT', 'Dania lekkie, nie zawierają w sobie składników uznawanych za tuczące i dostarczające człowiekowi "pustych kalorii". Mają za to dużo chudego mięsa,
ryb, warzyw i owoców, a także roślinnych tłuszczy, które pomagają witaminom wchłonąć się do krwiobiegu', 'https://www.glamour.pl/uploads/media/default/0004/45/fit-obiad.jpeg');
insert into category (id, category_name, category_description, category_img_url)
values (9, 'VEGE', 'Dieta wykluczająca mięso i ryby, a pozostawiająca nabiał i jaja. Bogata w warzywa strączkowe i owoce. U podstawy piramidy żywieniowej wegan
znajdują się produkty na bazie zbóż, takich jak: pszenica, ryż, żyto, proso, owies, oraz owoce i warzywa', 'https://www.aloestudio.pl/wp-content/uploads/2018/04/DSC_2172_akontrast_Btl_BBml-750x500.jpg');


insert into recipe (id, title, description, time, difficulty, category_id, rating, preparation)
values (1, 'Zupa pomidorowa', 'Domowa zupa pomidorowa przywołuje najpiękniejsze wspomnienia z dzieciństwa.', 25, 'EASY', 6, 0, 'Zagotuj bulion/rosół. Dodaj przecier i wymieszaj.
Ponownie zagotuj. Dopraw do smaku solą i pieprzem. Podawaj z ugotowanym ryżem i natką pietruszki.');
insert into recipe (id, title, description, time, difficulty, category_id, rating, preparation)
values (2, 'Makaron z pesto z rukoli i pomidorkami', 'Obłędnie zielone, zachwycająco smaczne i błyskawiczne w przygotowaniu!', 15, 'EASY', 2, 0, 'Rozgrzej dużą
patelnię, wsyp na nią orzeszki pinii i poczekaj 1–2 minuty, aż lekko zbrązowieją. Odstaw z palnika. Przesyp je do wysokiego naczynia');

insert into ingredient (id, name, quantity, unit, additional_info, recipe_id)
values (1, 'bulionu', 2, 'L', 'polecam z rosołu z dnia poprzedniego', 1);
insert into ingredient (id, name, quantity, unit, additional_info, recipe_id)
values (2, 'domowego przecieru pomidorowego', 700, 'ML', 'lub 500 ml kupnej passaty pomidorowej', 1);
insert into ingredient (id, name, quantity, unit, additional_info, recipe_id)
values (3, 'śmietany', 200, 'ML', '12 lub 18%', 1);
insert into ingredient (id, name, quantity, unit, additional_info, recipe_id)
values (4, 'ryżu', 200, 'G', 'ugotowany', 1);

insert into ingredient (id, name, quantity, unit, additional_info, recipe_id)
values (5, 'makaronu', 250, 'G', 'np spaghetti', 2);