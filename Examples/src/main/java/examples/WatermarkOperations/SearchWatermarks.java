package examples.WatermarkOperations;

import com.groupdocs.cloud.watermark.api.WatermarkApi;
import com.groupdocs.cloud.watermark.client.ApiException;
import com.groupdocs.cloud.watermark.model.FileInfo;
import com.groupdocs.cloud.watermark.model.ImageSearchCriteria;
import com.groupdocs.cloud.watermark.model.SearchOptions;
import com.groupdocs.cloud.watermark.model.SearchResult;
import com.groupdocs.cloud.watermark.model.SearchResultItem;
import com.groupdocs.cloud.watermark.model.TextSearchCriteria;
import com.groupdocs.cloud.watermark.model.requests.SearchRequest;

import examples.Common;

/**
 * This example demonstrates how to obtain document file information.
 */
public class SearchWatermarks {

	public static void main(String[] args) {

		WatermarkApi apiInstance = new WatermarkApi(Common.GetConfiguration());

		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("with_watermarks/sample.pdf");
			fileInfo.setStorageName(Common.MyStorage);
			SearchOptions options = new SearchOptions();
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

			options.setOutputFolder("found_image_watermarks");

			SearchRequest request = new SearchRequest(options);
			SearchResult response = apiInstance.search(request);
			for (SearchResultItem watermark : response.getWatermarks()) {
				System.out.println("Id: " + watermark.getId() + ", Type: " + watermark.getPossibleWatermarkType()
						+ ", Height: " + watermark.getHeight() + ", Width: " + watermark.getWidth());
				if (watermark.getText() != null) {
					System.out.println("Text: " + watermark.getText());
				}

				if (watermark.getImageUrl() != null) {
					System.out.println("ImageUrl: " + watermark.getImageUrl());
				}
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling WatermarkApi:");
			e.printStackTrace();
		}
	}
}