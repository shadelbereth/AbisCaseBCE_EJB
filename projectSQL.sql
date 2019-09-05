--------------------------------------------------------
--  DDL for Table PROJECT
--------------------------------------------------------

  CREATE TABLE "TU00006"."PROJECT" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(50 BYTE), 
	"DESCRIPTION" VARCHAR2(255 BYTE), 
	"COMPANYID" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TS_USERS" ;
--------------------------------------------------------
--  DDL for Index PROJECT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TU00006"."PROJECT_PK" ON "TU00006"."PROJECT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TS_USERS" ;
--------------------------------------------------------
--  Constraints for Table PROJECT
--------------------------------------------------------

  ALTER TABLE "TU00006"."PROJECT" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "TU00006"."PROJECT" MODIFY ("COMPANYID" NOT NULL ENABLE);
  ALTER TABLE "TU00006"."PROJECT" ADD CONSTRAINT "PROJECT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TS_USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PROJECT
--------------------------------------------------------

  ALTER TABLE "TU00006"."PROJECT" ADD CONSTRAINT "CO_ID" FOREIGN KEY ("COMPANYID")
	  REFERENCES "TU00006"."COMPANY" ("ID") ENABLE;
