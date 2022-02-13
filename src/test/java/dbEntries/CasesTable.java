package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class CasesTable {
    public static Logger logger = Logger.getLogger(CasesTable.class);

    DataBaseService dataBaseService;

    public CasesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу cases");

        String createTableSQL = "CREATE TABLE cases (" +
                "id SERIAL PRIMARY KEY, " +
                "name CHARACTER VARYING(30), " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу cases");

        String dropTableCasesSQL = "DROP TABLE cases;";

        dataBaseService.executeSQL(dropTableCasesSQL);
    }

    public ResultSet getAllCases() {
        logger.info("Получаем все записи из таблицы cases");

        String sql = "SELECT * FROM cases ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getCaseById(int id) {
        String sql = "SELECT * FROM cases WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addCase(String name) {
        logger.info("Добавляем запист в таблицу cases");

        String insertTableSQL = "INSERT INTO public.cases(" +
                "name)" +
                "VALUES ('" + name + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
