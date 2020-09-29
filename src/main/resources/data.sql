insert into recipe (id, title, description, time, difficulty, category, rating)
values (1, 'Zupa pomidorowa', 'Domowa zupa pomidorowa przywołuje najpiękniejsze wspomnienia z dzieciństwa.', 25, 'EASY', 1, 0);
insert into recipe (id, title, description, time, difficulty, category, rating)
values (2, 'Makaron z pesto z rukoli i pomidorkami', 'Obłędnie zielone, zachwycająco smaczne i błyskawiczne w przygotowaniu!', 15, 'EASY', 2, 0);

insert into ingredient (id, name, quantity, unit, description, recipe_id)
values (1, 'bulionu', 2, 'L', 'polecam z rosołu z dnia poprzedniego', 1);
insert into ingredient (id, name, quantity, unit, description, recipe_id)
values (2, 'domowego przecieru pomidorowego', 700, 'ML', 'lub 500 ml kupnej passaty pomidorowej', 1);
insert into ingredient (id, name, quantity, unit, description, recipe_id)
values (3, 'śmietany', 200, 'ML', '12 lub 18%', 1);
insert into ingredient (id, name, quantity, unit, description, recipe_id)
values (4, 'ryżu', 200, 'G', 'ugotowany', 1);

insert into ingredient (id, name, quantity, unit, description, recipe_id)
values (5, 'makaronu', 250, 'G', 'np spaghetti', 2);