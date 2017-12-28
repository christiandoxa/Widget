package com.example.android.mygarden;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.android.mygarden.ui.MainActivity;

/**
 * Created by doxa on 28/12/17.
 */

public class PlantWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        //membuat intent untuk launch main activity ketika di click
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        //membangun remote views object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.plant_widget);
        //membuat click handler berfungsi untuk launch pending intent
        views.setOnClickPendingIntent(R.id.widget_plant_image, pendingIntent);
        //menginstruksikan widget manager untuk mengupdate widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
