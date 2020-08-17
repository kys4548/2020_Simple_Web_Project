## Postgres

### Run Postgres Container

```$xslt
docker run --name rest -p 5432:5432 -e POSTGRES_PASSWORD=pass -d postgres

docker exec -i -t rest bash
```

Then you will see the container bash as a root user.

```$xslt
su - postgres



psql -d postgres -U postgres

or

psql -d postgres -U postgres -W
pass

```