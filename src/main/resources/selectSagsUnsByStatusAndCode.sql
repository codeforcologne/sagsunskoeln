SELECT
  id,status,serviceCode,serviceName,description,requesteddatetime,updateddatetime,address,mediaurl,statusnotes,lat,lng
FROM
  sagsuns
WHERE 
  status = ? and servicecode = ?