package id.bustomi.d3ti.uns.readmysign2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.net.URL;

import id.bustomi.d3ti_uns.readmysign2.R;

public class MenuActivity extends Activity {

    private static final int NUM_WORDS = 75;
    private Button a, b, c, d, e, f, g, h, i, j, k, l, m, n, ñ, o, p, q, r, s, t, u, v, w, x, y, z;
    private Button translateButton;
    private Button showABCButton;
    private Button signToTextButton;
    private WebView translateWebView;
    private String defaultVideo;
    private String urlVideo;
    private EditText translateText;
    private LinearLayout abcLayout;
    private String[] words;
    private int cont;
    private boolean state = false;
    private final static String GIF_IP = "http://192.168.43.85";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        translateWebView = (WebView) findViewById(R.id.translate_webView);
        translateText = (EditText) findViewById(R.id.translate_text);
        translateButton = (Button) findViewById(R.id.translateButton);
        showABCButton = (Button) findViewById(R.id.show_acb_button);
        signToTextButton = (Button) findViewById(R.id.sign_to_text_button);
        abcLayout = (LinearLayout) findViewById(R.id.acb_buttons);
        defaultVideo = GIF_IP+"/static-lense/translate/default.gif";
        urlVideo = GIF_IP+"/static-lense/translate/";

        defaultVideo = "https://raw.githubusercontent.com/FranciscoYimes/static-lense/master/translate/a.gif";
        urlVideo = "https://raw.githubusercontent.com/FranciscoYimes/static-lense/master/translate/";

        updateWords();


        retrieveExistingWords();

        translateWebView.loadUrl(defaultVideo);

        a = (Button) findViewById(R.id.a);
        b = (Button) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        d = (Button) findViewById(R.id.d);
        e = (Button) findViewById(R.id.e);
        f = (Button) findViewById(R.id.f);
        g = (Button) findViewById(R.id.g);
        h = (Button) findViewById(R.id.h);
        i = (Button) findViewById(R.id.i);
        j = (Button) findViewById(R.id.j);
        k = (Button) findViewById(R.id.k);
        l = (Button) findViewById(R.id.l);
        m = (Button) findViewById(R.id.m);
        n = (Button) findViewById(R.id.n);
        ñ = (Button) findViewById(R.id.ñ);
        o = (Button) findViewById(R.id.o);
        p = (Button) findViewById(R.id.p);
        q = (Button) findViewById(R.id.q);
        r = (Button) findViewById(R.id.r);
        s = (Button) findViewById(R.id.s);
        t = (Button) findViewById(R.id.t);
        u = (Button) findViewById(R.id.u);
        v = (Button) findViewById(R.id.v);
        w = (Button) findViewById(R.id.w);
        x = (Button) findViewById(R.id.x);
        y = (Button) findViewById(R.id.y);
        z = (Button) findViewById(R.id.z);

        signToTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        showABCButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                state = true;
                translateText.setVisibility(View.INVISIBLE);
                abcLayout.setVisibility(View.VISIBLE);
                showABCButton.setVisibility(View.GONE);
                signToTextButton.setVisibility(View.GONE);
                translateButton.setText("Volver");
            }
        });

        translateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (state)
                {
                    translateButton.setText("Traducir");
                    state = false;
                    translateText.setVisibility(View.VISIBLE);
                    abcLayout.setVisibility(View.GONE);
                    showABCButton.setVisibility(View.VISIBLE);
                    signToTextButton.setVisibility(View.VISIBLE);
                } else if (!translateText.getText().toString().isEmpty())
                    PlayVideo(translateText.getText().toString().toLowerCase());
            }
        });

        a.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "a.gif");
            }
        });
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "b.gif");
            }
        });
        c.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "c.gif");
            }
        });
        d.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "d.gif");
            }
        });
        e.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "e.gif");
            }
        });
        f.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "f.gif");
            }
        });
        g.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "g.gif");
            }
        });
        h.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "h.gif");
            }
        });
        i.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "i.gif");
            }
        });
        j.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "j.gif");
            }
        });
        k.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "k.gif");
            }
        });
        l.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "l.gif");
            }
        });
        m.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "m.gif");
            }
        });
        n.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "n.gif");
            }
        });
        ñ.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "ñ.gif");
            }
        });
        o.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "o.gif");
            }
        });
        p.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "p.gif");
            }
        });
        q.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "q.gif");
            }
        });
        r.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "r.gif");
            }
        });
        s.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "s.gif");
            }
        });
        t.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "t.gif");
            }
        });
        u.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "u.gif");
            }
        });
        v.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "v.gif");
            }
        });
        w.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "w.gif");
            }
        });
        x.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "x.gif");
            }
        });
        y.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "y.gif");
            }
        });
        z.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                translateWebView.loadUrl(urlVideo + "z.gif");
            }
        });

        retrieveExistingWords();

    }

    public void updateWords()
    {
        words = new String[NUM_WORDS];

        words[0] = "a";words[1] = "b";words[2] = "c";words[3] = "d";words[4] = "e";words[5] = "f";words[6] = "g";words[7] = "h";words[8] = "i";words[9] = "j";words[10] = "k";words[11] = "l";words[12] = "m";words[13] = "n";words[14] = "ñ";words[15] = "o";words[16] = "p";words[17] = "q";words[18] = "r";words[19] = "s";words[20] = "t";words[21] = "u";words[22] = "v";words[23] = "w";words[24] = "x";words[25] = "y";words[26] = "z";words[27] = "";
        words[28] = "lunes";
        words[29] = "martes";
        words[30] = "miercoles";
        words[31] = "jueves";
        words[32] = "viernes";
        words[33] = "sabado";
        words[34] = "domingo";
        words[35] = "enero";
        words[36] = "febrero";
        words[37] = "marzo";
        words[38] = "abril";
        words[39] = "mayo";
        words[40] = "junio";
        words[41] = "julio";
        words[42] = "agosto";
        words[43] = "septiembre";
        words[44] = "octubre";
        words[45] = "noviembre";
        words[46] = "diciembre";
        words[47] = "hola";
        words[48] = "adios";
        words[49] = "gracias";
        words[50] = "como estas";
        words[51] = "por que";
        words[52] = "muchas gracias";
        words[53] = "mal";
        words[54] = "donde";
        words[55] = "de nada";
        words[56] = "cuando";
        words[57] = "cual";
        words[58] = "como";
        words[59] = "buenos dias";
        words[60] = "buenas tardes";
        words[61] = "buenas noches";
        words[62] = "bien";
        words[63] = "amarillo";
        words[64] = "celeste";
        words[65] = "azul";
        words[66] = "blanco";
        words[67] = "cafe";
        words[68] = "calipso";
        words[69] = "dorado";
        words[70] = "fucsia";
        words[71] = "morado";
        words[72] = "plateado";
        words[73] = "rosado";
        words[74] = "verde";

    }

    public boolean issetWord(String word)
    {
        for (int i = 0; i < NUM_WORDS; i++)
        {
            if (words[i].equals(word)) return true;
        }
        return false;
    }

    public void PlayVideo(String text)
    {

        if (issetWord(text)) translateWebView.loadUrl(videoConcat(text));
    }

    public void retrieveExistingWords()
    {
        /*
        Form form = new Form("http://192.168.43.85/static-lense/load_translate_words.php")
        {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                // TODO: AQUI ESTOY LISTO!!
                Log.d("LDEB", jsonObject.toString());
            }

            @Override public void onFailure(FailureReason reason, String message)
            {
                // TODO: AQUI HUBO UN ERROR!!
                Log.e("LDEB", reason + " -> " + message);
            }

            @Override public void onValidationFailed(Field field)
            {

            }
        };

        form.submit();
        */
    }

    public String videoConcat(String word)
    {
        String url = urlVideo;
        url = url + word + ".gif";
        return url;
    }

    public boolean exists(String URLName)
    {
        try
        {
            URL url = new URL(URLName);
            InputStream is = url.openStream();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
