FROM postgres:15

ENV POSTGRES_DB=emreDB \
    POSTGRES_USER=emre \
    POSTGRES_PASSWORD=1234

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432
