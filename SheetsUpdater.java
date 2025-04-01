import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;

public class SheetsUpdater {
    private final String spreadsheetId;
    private final Sheets service;

    public SheetsUpdater(String spreadsheetId, Sheets service) {
        this.spreadsheetId = spreadsheetId;
        this.service = service;
    }

    UpdateValuesResponse updateSheet(String range, ValueRange body, String valueInputOption) throws IOException {
        UpdateValuesResponse result = service.spreadsheets().values()
                .update(spreadsheetId, range, body)
                .setValueInputOption(valueInputOption)
                .execute();
        return result;
    }
}
