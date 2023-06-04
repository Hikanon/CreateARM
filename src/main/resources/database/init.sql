SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE TABLE IF NOT EXISTS public.cpec (
                             cod character varying(255) NOT NULL,
                             liter character varying(255),
                             nam character varying(255),
                             id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.grup (
                             id integer NOT NULL,
                             nomer character varying(255),
                             id_cpec integer
);

CREATE TABLE IF NOT EXISTS public.kafedra (
                                id integer NOT NULL,
                                nam character varying(255)
);

CREATE TABLE IF NOT EXISTS public.marks (
                              mark integer NOT NULL,
                              nam character varying(255),
                              id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.otchetn (
                                id integer NOT NULL,
                                nam character varying(255)
);

CREATE TABLE IF NOT EXISTS public.pln (
                            id integer NOT NULL,
                            id_subj integer,
                            semestr integer,
                            id_otch integer,
                            id_cpec integer
);

CREATE TABLE IF NOT EXISTS public.premiya (
                                fami character varying(255),
                                imya character varying(255),
                                srball real,
                                summa integer,
                                id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.prep (
                             id integer NOT NULL,
                             fam character varying(255),
                             nam character varying(255),
                             otc character varying(255),
                             id_kaf integer
);

CREATE TABLE IF NOT EXISTS public.sessia (
                               id integer NOT NULL,
                               id_pln integer,
                               id_stud integer,
                               id_mark integer
);

CREATE TABLE IF NOT EXISTS public.sessia (
                               id integer NOT NULL,
                               id_pln integer,
                               id_stud integer,
                               id_mark integer
);

CREATE TABLE IF NOT EXISTS public.student (
                                id integer NOT NULL,
                                id_grup integer,
                                fam character varying(255),
                                nam character varying(255),
                                otc character varying(255),
                                pol character varying(255),
                                rozhd date,
                                ves real,
                                rost real
);

CREATE TABLE IF NOT EXISTS public.subject (
                                id integer NOT NULL,
                                nam character varying(255),
                                id_kaf integer
);

SET default_tablespace = '';

SET default_table_access_method = heap;
