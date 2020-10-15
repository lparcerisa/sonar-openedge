DEFINE VARIABLE l1 AS LOGICAL.
DEFINE VARIABLE h1 AS HANDLE.
DEF VAR xxx AS INT.

mainBlock:
DO ON ERROR   UNDO mainBlock, LEAVE mainBlock
   ON END-KEY UNDO mainBlock, LEAVE mainBlock:

    RUN proc1 NO-ERROR.
    IF ERROR-STATUS:ERROR THEN RETURN.

    IF l1 AND VALID-HANDLE(h1) THEN DO:
        ON "WINDOW-CLOSE" OF h1 DO:
          DEF VAR xxx AS INT.
          MESSAGE xxx.
          APPLY "CLOSE" TO THIS-PROCEDURE.
        END.
        MESSAGE xxx.
        WAIT-FOR CLOSE OF THIS-PROCEDURE.
    END.
END.