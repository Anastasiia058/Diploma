INSERT INTO route (id_route, name_route) values (97, 'Київ-Ковель');
INSERT INTO route (id_route, name_route) values (7, 'Київ-Чоп');
INSERT INTO route (id_route, name_route) values (117, 'Київ-Чернівці');
INSERT INTO route (id_route, name_route) values (105, 'Київ-Одеса');
INSERT INTO route (id_route, name_route) values (755, 'Київ-Луцьк');
INSERT INTO route (id_route, name_route) values (98, 'Ковель-Київ');
INSERT INTO route (id_route, name_route) values (8, 'Чоп-Київ');
INSERT INTO route (id_route, name_route) values (118, 'Чернівці-Київ');
INSERT INTO route (id_route, name_route) values (106, 'Одеса-Київ');
INSERT INTO route (id_route, name_route) values (756, 'Луцьк-Київ');

INSERT INTO train (name_train, type_train, class_train, status_train) values ('Cвітязь', 'Нічний швидкий', 2, 'В депо');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Cвітязь', 'Нічний швидкий', 2, 'В дорозі');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Cвітязь', 'Нічний швидкий', 2, 'Аварійна ситуація');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Cвітязь', 'Нічний швидкий', 2, 'Ремонт');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Дукла', 'Швидкий', 2, 'В депо');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Дукла', 'Швидкий', 2, 'В дорозі');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Дукла', 'Швидкий', 2, 'Аварійна ситуація');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Дукла', 'Швидкий', 2, 'Ремонт');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Буковина', 'Нічний швидкий', 2, 'В депо');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Буковина', 'Нічний швидкий', 2, 'В дорозі');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Буковина', 'Нічний швидкий', 2, 'Аварійна ситуація');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Буковина', 'Нічний швидкий', 2, 'Ремонт');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Чорноморець', 'Нічний швидкий', 1, 'В депо');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Чорноморець', 'Нічний швидкий', 1, 'В дорозі');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Чорноморець', 'Нічний швидкий', 1, 'Аварійна ситуація');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Чорноморець', 'Нічний швидкий', 1, 'Ремонт');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Столичний експерес', 'Інтерсіті', 1, 'В депо');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Столичний експерес', 'Інтерсіті', 1, 'В дорозі');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Столичний експерес', 'Інтерсіті', 1, 'Аварійна ситуація');
INSERT INTO train (name_train, type_train, class_train, status_train) values ('Столичний експерес', 'Інтерсіті', 1, 'Ремонт');

INSERT INTO station (name_station) values ('Київ-Пасажирський');
INSERT INTO station (name_station) values ('Новоград-Волинський');
INSERT INTO station (name_station) values ('Шепетівка');
INSERT INTO station (name_station) values ('Здолбунів');
INSERT INTO station (name_station) values ('Рівне');
INSERT INTO station (name_station) values ('Ковель');
INSERT INTO station (name_station) values ('Козятин');
INSERT INTO station (name_station) values ('Вінниця');
INSERT INTO station (name_station) values ('Тернопіль');
INSERT INTO station (name_station) values ('Підзамче');
INSERT INTO station (name_station) values ('Львів');
INSERT INTO station (name_station) values ('Стрілки');
INSERT INTO station (name_station) values ('Ужгород');
INSERT INTO station (name_station) values ('Чоп');
INSERT INTO station (name_station) values ('Івано-Франківськ');
INSERT INTO station (name_station) values ('Коломия');
INSERT INTO station (name_station) values ('Чернівці');
INSERT INTO station (name_station) values ('Крижопіль');
INSERT INTO station (name_station) values ('Подільск');
INSERT INTO station (name_station) values ('Одеса');
INSERT INTO station (name_station) values ('Фастів');
INSERT INTO station (name_station) values ('Бердичів');
INSERT INTO station (name_station) values ('Луцьк');

INSERT INTO train_has_route (id_train, id_route) values (2, 97);
INSERT INTO train_has_route (id_train, id_route) values (2, 98);
INSERT INTO train_has_route (id_train, id_route) values (6, 7);
INSERT INTO train_has_route (id_train, id_route) values (6, 8);
INSERT INTO train_has_route (id_train, id_route) values (10, 117);
INSERT INTO train_has_route (id_train, id_route) values (10, 118);
INSERT INTO train_has_route (id_train, id_route) values (14, 105);
INSERT INTO train_has_route (id_train, id_route) values (14, 106);
INSERT INTO train_has_route (id_train, id_route) values (18, 755);
INSERT INTO train_has_route (id_train, id_route) values (18, 756);


INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 1);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 1);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 2);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 2);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 3);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 3);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 4);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 4);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 5);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 5);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 6);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 6);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 7);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 7);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 8);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 8);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 9);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 9);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 10);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 10);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 11);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 11);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 12);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 12);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 13);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 13);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 14);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 14);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 15);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 15);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 16);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 16);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 17);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 17);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 18);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 18);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 19);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 19);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 20);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 20);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 21);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 21);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 22);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 22);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 1, 23);
INSERT INTO track (track_status, track_number, id_station) values ('Вільна', 2, 23);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:42:00', '21:57:00', 97, 1, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:23:00', '01:25:00', 97, 2, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:13:00', '02:33:00', 97, 3, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:50:00', '04:08:00', 97, 4, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:23:00', '04:33:00', 97, 5, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:30:00', '08:45:00', 97, 6, 'Вт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:42:00', '21:57:00', 97, 1, 'Ср', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:23:00', '01:25:00', 97, 2, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:13:00', '02:33:00', 97, 3, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:50:00', '04:08:00', 97, 4, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:23:00', '04:33:00', 97, 5, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:30:00', '08:45:00', 97, 6, 'Чт', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:56:00', '19:11:00', 7, 1, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:06:00', '20:08:00', 7, 21, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:42:00', '22:58:00', 7, 8, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:05:00', '03:30:00', 7, 9, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:36:00', '05:38:00', 7, 10, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:50:00', '06:16:00', 7, 11, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:11:00', '08:13:00', 7, 12, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:00:00', '12:13:00', 7, 13, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:36:00', '12:50:00', 7, 14, 'Ср', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:56:00', '19:11:00', 7, 1, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:06:00', '20:08:00', 7, 21, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:42:00', '22:58:00', 7, 8, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:05:00', '03:30:00', 7, 9, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:36:00', '05:38:00', 7, 10, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:50:00', '06:16:00', 7, 11, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:11:00', '08:13:00', 7, 12, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:00:00', '12:13:00', 7, 13, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:36:00', '12:50:00', 7, 14, 'Пт', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:16:00', '20:21:00', 117, 1, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:11:00', '03:31:00', 117, 11, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:48:00', '05:58:00', 117, 15, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:57:00', '06:59:00', 117, 16, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:28:00', '08:42:00', 117, 17, 'Чт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:16:00', '20:21:00', 117, 1, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:11:00', '03:31:00', 117, 11, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:48:00', '05:58:00', 117, 15, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:57:00', '06:59:00', 117, 16, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:28:00', '08:42:00', 117, 17, 'Сб', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:02:00', '21:17:00', 105, 1, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:24:00', '23:26:00', 105, 7, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:15:00', '00:17:00', 105, 8, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:17:00', '02:19:00', 105, 18, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:45:00', '03:47:00', 105, 19, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:15:00', '06:30:00', 105, 20, 'Чт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:02:00', '21:17:00', 105, 1, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:24:00', '23:26:00', 105, 7, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:15:00', '00:17:00', 105, 8, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:17:00', '02:19:00', 105, 18, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:45:00', '03:47:00', 105, 19, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:15:00', '06:30:00', 105, 20, 'Сб', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Пн', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Вт', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Ср', 3);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Чт', 4);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Пт', 5);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Сб', 6);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:12:00', '07:27:00', 755, 1, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('08:21:00', '08:23:00', 755, 21, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:40:00', '09:42:00', 755, 22, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('11:01:00', '11:03:00', 755, 3, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:05:00', '12:06:00', 755, 4, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('12:19:00', '12:21:00', 755, 5, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:25:00', '13:40:00', 755, 23, 'Нд', 7);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:40:00', '18:55:00', 98, 6, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:53:00', '22:58:00', 98, 5, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:12:00', '23:30:00', 98, 4, 'Вт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:46:00', '00:48:00', 98, 3, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:47:00', '01:49:00', 98, 2, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:35:00', '05:50:00', 98, 1, 'Ср', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:40:00', '18:55:00', 98, 6, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:53:00', '22:58:00', 98, 5, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:12:00', '23:30:00', 98, 4, 'Чт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:46:00', '00:48:00', 98, 3, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:47:00', '01:49:00', 98, 2, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:35:00', '05:50:00', 98, 1, 'Пт', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:37:00', '13:52:00', 8, 14, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('14:14:00', '14:29:00', 8, 13, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:22:00', '18:25:00', 8, 12, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:35:00', '21:05:00', 8, 11, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:17:00', '21:19:00', 8, 10, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:10:00', '00:10:00', 8, 9, 'Ср', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:09:00', '04:14:00', 8, 8, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:05:00', '05:07:00', 8, 21, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:44:00', '07:59:00', 8, 1, 'Чт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('13:37:00', '13:52:00', 8, 14, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('14:14:00', '14:29:00', 8, 13, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('18:22:00', '18:25:00', 8, 12, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:35:00', '21:05:00', 8, 11, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:17:00', '21:19:00', 8, 10, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:10:00', '00:10:00', 8, 9, 'Пт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:09:00', '04:14:00', 8, 8, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('05:05:00', '05:07:00', 8, 21, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('07:44:00', '07:59:00', 8, 1, 'Сб', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:04:00', '21:19:00', 118, 17, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:29:00', '22:31:00', 118, 16, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:24:00', '23:40:00', 118, 15, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:10:00', '02:47:00', 118, 11, 'Пт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:45:00', '10:00:00', 118, 1, 'Пт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:04:00', '21:19:00', 118, 17, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('22:29:00', '22:31:00', 118, 16, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('23:24:00', '23:40:00', 118, 15, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('02:10:00', '02:47:00', 118, 11, 'Нд', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('09:45:00', '10:00:00', 118, 1, 'Нд', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:17:00', '21:32:00', 106, 20, 'Чт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:08:00', '00:10:00', 106, 19, 'Пт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:41:00', '01:43:00', 106, 18, 'Пт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:42:00', '03:44:00', 106, 8, 'Пт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:34:00', '04:36:00', 106, 7, 'Пт', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:54:00', '07:09:00', 106, 1, 'Пт', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:17:00', '21:32:00', 106, 20, 'Сб', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('00:08:00', '00:10:00', 106, 19, 'Нд', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('01:41:00', '01:43:00', 106, 18, 'Нд', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('03:42:00', '03:44:00', 106, 8, 'Нд', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('04:34:00', '04:36:00', 106, 7, 'Нд', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('06:54:00', '07:09:00', 106, 1, 'Нд', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Пн', 1);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Пн', 1);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Вт', 2);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Вт', 2);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Ср', 3);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Ср', 3);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Чт', 4);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Чт', 4);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Пт', 5);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Пт', 5);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Сб', 6);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Сб', 6);

INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('15:05:00', '15:20:00', 756, 23, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:26:00', '16:28:00', 756, 5, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('16:42:00', '16:43:00', 756, 4, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('17:44:00', '17:46:00', 756, 3, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('19:10:00', '19:12:00', 756, 22, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('20:23:00', '20:25:00', 756, 21, 'Нд', 7);
INSERT INTO schedule (arrival, departure, id_route, id_station, day_week, trip) values ('21:10:00', '21:25:00', 756, 1, 'Нд', 7);
