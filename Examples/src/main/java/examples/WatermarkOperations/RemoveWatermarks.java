package examples.WatermarkOperations;

import com.groupdocs.cloud.watermark.api.WatermarkApi;
import com.groupdocs.cloud.watermark.client.ApiException;
import com.groupdocs.cloud.watermark.model.FileInfo;
import com.groupdocs.cloud.watermark.model.ImageSearchCriteria;
import com.groupdocs.cloud.watermark.model.RemoveOptions;
import com.groupdocs.cloud.watermark.model.RemoveResult;
import com.groupdocs.cloud.watermark.model.TextSearchCriteria;
import com.groupdocs.cloud.watermark.model.requests.RemoveRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain document file information.
 */
public class RemoveWatermarks {

	public static void main(String[] args) {

		WatermarkApi apiInstance = new WatermarkApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("with_watermarks/sample.pdf");
			fileInfo.setStorageName(Common.MyStorage);
			RemoveOptions options = new RemoveOptions();
			options.setFileInfo(fileInfo);
			
			ImageSearchCriteria imageSearchCriteria = new ImageSearchCriteria();
			FileInfo imageFileInfo = new FileInfo();
			imageFileInfo.setFilePath("watermark_images/sample_watermark.png");
			imageFileInfo.setStorageName(Common.MyStorage);
			imageSearchCriteria.setImageFileInfo(imageFileInfo);
			options.setImageSearchCriteria(imageSearchCriteria);
			
			TextSearchCriteria textSearchCriteria = new TextSearchCriteria();
			textSearchCriteria.setSearchText("Watermark text");
			options.setTextSearchCriteria(textSearchCriteria);
			
			options.setOutputFolder("removed_watermarks");
			
			RemoveRequest request = new RemoveRequest(options);
			RemoveResult response = apiInstance.remove(request);

			System.out.println("Resultant file path: " + response.getPath());
		} catch (ApiException e) {
			System.err.println("Exception while calling WatermarkApi:");
			e.printStackTrace();
		}
	}
}