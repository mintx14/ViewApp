package my.utem.ftmk.ViewApp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import my.utem.ftmk.ViewApp.R;
import my.utem.ftmk.ViewApp.databinding.FragmentGetJokeActivityBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetJokeActivityFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetJokeActivityFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GetJokeActivityFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GetJokeActivityFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static GetJokeActivityFrag newInstance(String param1, String param2) {
        GetJokeActivityFrag fragment = new GetJokeActivityFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentGetJokeActivityBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_get_joke_activity, container, false);
        binding = FragmentGetJokeActivityBinding.inflate(inflater, container, false);
        binding.btnGetJoke.setOnClickListener(this::fnGetJoke);
        return binding.getRoot();
    }

    private void fnGetJoke(View view) {
        String strUrl = "https://official-joke-api.appspot.com/random_joke";
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, strUrl, new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            binding.txtVwJokeType.setText((jsonObject.getString("type")));
                            binding.txtVwSetup.setText(jsonObject.getString("setup"));
                            binding.txtVwPunchline.setText(jsonObject.getString("punchline"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Unable to connect to the joke!" +
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }

    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}