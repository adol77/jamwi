package com.vogella.android.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.util.AttributeSet;

//뷰를 상속받아 새로운 뷰를 만든다
public class CustomViewStyles extends View {
 
 // paint객체 - 그래픽 그리기를 위해 필요한 색깔 , 폰트 등을 저장하는곳
 private Paint paint;
 public int visitCount = 10;
 public int tableCount = 10;

 public CustomViewStyles(Context context) {
  super(context);

  paint = new Paint();
 }

 public CustomViewStyles(Context context, AttributeSet attr) {
  super(context, attr);

  paint = new Paint();
 }

 protected void onDraw(Canvas canvas) {
  super.onDraw(canvas);

  // 첫번째 사각형
  paint.setStyle(Style.STROKE);
  paint.setColor(Color.BLUE);
  canvas.drawRect(0, 0, tableCount * 8, 25, paint);
   /*
  paint.setStyle(Style.STROKE);
  paint.setStrokeWidth(2.0F);
  paint.setColor(Color.GREEN);
  canvas.drawRect(10, 10, 100, 100, paint);
*/
  // 두번째 사각형
  int jam = visitCount * 250 / tableCount;
  if (jam > 255) jam = 255;

  paint.setStyle(Style.FILL);
  paint.setARGB(128, jam, 255 - jam, 0);
  canvas.drawRect(1, 1, visitCount * 8, 20, paint);

  /*
  DashPathEffect dashEffect = new DashPathEffect(new float[]{5,5}, 1);
  paint.setStyle(Style.STROKE);
  paint.setStrokeWidth(3.0F);
  paint.setPathEffect(dashEffect);
  paint.setColor(Color.GREEN);
  canvas.drawRect(120, 10, 210, 100, paint);
  */

  /*
  paint = new Paint();
  
  // 첫번째 원
  paint.setColor(Color.MAGENTA);
  canvas.drawCircle(50, 160, 40, paint);
  
  // 두번째 원
  // paint.setAntiAlias(true); 좀더 부드럽게 보이게 해준다
  paint.setAntiAlias(true);
  canvas.drawCircle(160, 160, 40, paint);
  
  // 첫번째
  paint.setStyle(Style.STROKE);
  paint.setStrokeWidth(1);
  paint.setColor(Color.MAGENTA);
  paint.setTextSize(30);
  canvas.drawText("Text (Stroke)", 20, 260, paint);

  // 첫번째 텍스트
  paint.setStyle(Style.FILL);
  paint.setTextSize(30);
  canvas.drawText("Text (채우기)", 20, 320, paint);
  */
 }
 
}