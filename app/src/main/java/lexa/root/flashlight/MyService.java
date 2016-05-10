package lexa.root.flashlight;

import android.app.Service;
import android.content.Intent;
import android.hardware.Camera;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    private Camera camera = null;
    private Camera.Parameters params = null;


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (camera != null) {
            camera.release();
        }

try {


    camera = Camera.open();
    params = camera.getParameters();
    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
    camera.setParameters(params);
    camera.startPreview();


    Toast.makeText(this, "Фонарик включен", Toast.LENGTH_LONG).show();
}
catch (Exception e){

    Toast.makeText(this, "Вспышка не фурычит", Toast.LENGTH_LONG).show();


}
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {


    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

        params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.stopPreview();


        Toast.makeText(this,"Фонарик выключен",Toast.LENGTH_LONG).show();
        super.onTaskRemoved(rootIntent);
    }
}

