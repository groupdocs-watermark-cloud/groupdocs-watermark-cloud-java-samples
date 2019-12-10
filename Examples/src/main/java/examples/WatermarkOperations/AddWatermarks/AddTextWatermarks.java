package examples.WatermarkOperations.AddWatermarks;

import java.util.ArrayList;
import java.util.List;

import com.groupdocs.cloud.watermark.api.WatermarkApi;
import com.groupdocs.cloud.watermark.client.ApiException;
import com.groupdocs.cloud.watermark.model.FileInfo;
import com.groupdocs.cloud.watermark.model.TextWatermarkOptions;
import com.groupdocs.cloud.watermark.model.WatermarkDetails;
import com.groupdocs.cloud.watermark.model.WatermarkOptions;
import com.groupdocs.cloud.watermark.model.WatermarkResult;
import com.groupdocs.cloud.watermark.model.requests.AddRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain document file information.
 */
public class AddTextWatermarks {

	public static void main(String[] args) {

		WatermarkApi apiInstance = new WatermarkApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("documents/sample.docx");
			fileInfo.setStorageName(Common.MyStorage);
			WatermarkOptions options = new WatermarkOptions();
			options.setFileInfo(fileInfo);
			WatermarkDetails watermarkDetails = new WatermarkDetails();
			TextWatermarkOptions textWatermarkOptions = new TextWatermarkOptions();
			textWatermarkOptions.setText("New watermark text");
			textWatermarkOptions.setFontFamilyName("Arial");
			textWatermarkOptions.setFontSize(12d);
			watermarkDetails.setTextWatermarkOptions(textWatermarkOptions);
			List<WatermarkDetails> watermarkDetailsList = new ArrayList<WatermarkDetails>();
			watermarkDetailsList.add(watermarkDetails);
			options.setWatermarkDetails(watermarkDetailsList);
			AddRequest request = new AddRequest(options);
			WatermarkResult response = apiInstance.add(request);

			System.out.println("Resultant file path: " + response.getPath());
		} catch (ApiException e) {
			System.err.println("Exception while calling WatermarkApi:");
			e.printStackTrace();
		}
	}
}