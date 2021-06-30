package jhi.applogger.utils.ip;

import retrofit2.Call;
import retrofit2.http.*;

public interface IpLookupService
{
	@GET("{ip}?output=json&legacy=1")
	Call<IpLookupResponse> getIpDetails(@Path("ip") String ip, @Query("access_key") String accessKey);
}
