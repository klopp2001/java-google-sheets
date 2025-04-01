import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;

public class SheetsGetter {
    private final Sheets service;
    private final String spreadsheetId;

    public SheetsGetter( String spreadsheetId, Sheets service) {
        this.service = service;
        this.spreadsheetId = spreadsheetId;
    }

    ValueRange get(String range) throws IOException {
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        return response;
    }

    String getLastRow() throws IOException {
        ValueRange all = get("A2:A");
        var t =  all.getValues();
        Integer lastRow = all.getValues().size() + 2;
        return "A" + lastRow.toString();
    }
}
