--------------------------------------------------------
--  DDL for Table COMPANY
--------------------------------------------------------

  CREATE TABLE "TU00006"."COMPANY" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "TS_USERS" ;
--------------------------------------------------------
--  DDL for Index COPANY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TU00006"."COPANY_PK" ON "TU00006"."COMPANY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TS_USERS" ;
--------------------------------------------------------
--  Constraints for Table COMPANY
--------------------------------------------------------

  ALTER TABLE "TU00006"."COMPANY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "TU00006"."COMPANY" ADD CONSTRAINT "COPANY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "TS_USERS"  ENABLE;
