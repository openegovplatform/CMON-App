/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.userreg.portlet.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/** 
 * This is class ScaleImageUtil
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  12-Sept-2012  Nam Dinh    Create new
 */
public class ScaleImageUtil {
 
	/**
	 * This is function scaleImage
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param file
	 * @param int
	 * @param height
	 * @throws IOException
	 * @return Date
	 */
	public static byte[] scaleImage(File file, int width, int height) throws IOException{
		
		InputStream  imageFile = new FileInputStream(file);
				
		BufferedImage originalImage = ImageIO.read(imageFile);		
		
		BufferedImage resizedImage = resizeImage(originalImage, width, height);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		ImageIO.write(resizedImage, "jpg", out);
		
		return out.toByteArray();
 
    }
 
	/**
	 * This is function resizeImage
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param originalImage
	 * @param width
	 * @param height
	 * @return BufferedImage
	 */
    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height){
    	int type = originalImage.getType();
    	BufferedImage resizedImage = new BufferedImage(width, height, type);
    	Graphics2D g = resizedImage.createGraphics();
    	
    	g.drawImage(originalImage, 0, 0, width, height, null);
    	g.dispose();
 
    	return resizedImage;
    }	
}

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.RenderingHints;
//import java.awt.image.BufferedImage;
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//
//import javax.imageio.ImageIO;
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import sun.awt.image.codec.JPEGImageEncoderImpl;
//
///**
// * This utility class is used to re-size an image uploaded by citizen
// * This version of scale image util run on liferay 6.1.1 but not in 6.1.0
// * 
// * @author Nam Dinh
// * @date 8/31/2012
// *
// */
//public class ScaleImageUtil {
//	public static byte[] scaleImage(File imageFile, int p_width, int p_height) throws Exception {
//		InputStream  p_image = new FileInputStream(imageFile);
//		
//		InputStream imageStream = new BufferedInputStream(p_image);
//		Image image = (Image) ImageIO.read(imageStream); 
//	 
//		int thumbWidth = p_width;
//		int thumbHeight = p_height;        
//	 
//		//Make sure the aspect ratio is maintained, so the image is not skewed
//		double thumbRatio = (double)thumbWidth / (double)thumbHeight;
//       
//		int imageWidth = image.getWidth(null);
//		int imageHeight = image.getHeight(null);
//		double imageRatio = (double)imageWidth / (double)imageHeight;
//		
//		if (thumbRatio < imageRatio) {
//			thumbHeight = (int)(thumbWidth / imageRatio);
//		} else {
//			thumbWidth = (int)(thumbHeight * imageRatio);
//		}
//
//		// Draw the scaled image
//		BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
//		Graphics2D graphics2D = thumbImage.createGraphics();
//		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
//	 
//		// Write the scaled image to the outputstream
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);
//		
//		int quality = 100; // Use between 1 and 100, with 100 being highest quality
//		
//		quality = Math.max(0, Math.min(quality, 100));
//		param.setQuality((float)quality / 100.0f, false);
//		
//		encoder.setJPEGEncodeParam(param);
//		encoder.encode(thumbImage);        
//		ImageIO.write(thumbImage, "*.JPG" , out);     
//	 
//		return out.toByteArray();        
//	}	
//}
