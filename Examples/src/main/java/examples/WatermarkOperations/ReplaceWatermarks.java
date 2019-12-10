package examples.WatermarkOperations;

import com.groupdocs.cloud.watermark.api.WatermarkApi;
import com.groupdocs.cloud.watermark.client.ApiException;
import com.groupdocs.cloud.watermark.model.FileInfo;
import com.groupdocs.cloud.watermark.model.ImageSearchCriteria;
import com.groupdocs.cloud.watermark.model.ReplaceImageOptions;
import com.groupdocs.cloud.watermark.model.ReplaceOptions;
import com.groupdocs.cloud.watermark.model.ReplaceResult;
import com.groupdocs.cloud.watermark.model.ReplaceTextOptions;
import com.groupdocs.cloud.watermark.model.TextSearchCriteria;
import com.groupdocs.cloud.watermark.model.requests.ReplaceRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain document file information.
 */
public class ReplaceWatermarks {

	public static void main(String[] args) {

		WatermarkApi apiInstance = new WatermarkApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("with_watermarks/sample.pdf");
			fileInfo.setStorageName(Common.MyStorage);
			ReplaceOptions options = new ReplaceOptions();
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
			
			ReplaceTextOptions replaceTextOptions = new ReplaceTextOptions();
			replaceTextOptions.setText("New watermark text");
			options.setReplaceTextOptions(replaceTextOptions);
			
			ReplaceImageOptions replaceImageOptions = new ReplaceImageOptions();
			FileInfo replaceImageFileInfo = new FileInfo();
			replaceImageFileInfo.setFilePath("images/sample.jpg");
			replaceImageFileInfo.setStorageName(Common.MyStorage);
			replaceImageOptions.setImage(replaceImageFileInfo);
			options.setReplaceImageOptions(replaceImageOptions);

			options.setOutputFolder("found_image_watermarks");

			ReplaceRequest request = new ReplaceRequest(options);
			ReplaceResult response = apiInstance.replace(request);
			System.out.println("Resultant file path: " + response.getPath());
		} catch (ApiException e) {
			System.err.println("Exception while calling WatermarkApi:");
			e.printStackTrace();
		}
	}
}