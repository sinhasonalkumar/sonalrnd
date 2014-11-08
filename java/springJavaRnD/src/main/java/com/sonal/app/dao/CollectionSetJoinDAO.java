package com.sonal.app.dao;

public class CollectionSetJoinDAO {

	
	//String hqlString = "select new com.vo.RightsVO(ci.cid,ci.uvCid,rp.alid,d.projectId,d.profile,d.assetType) from Distribution d , Offer f , ContentItem ci , RightsProfile rp , IN(f.contents) fc , IN(ci.rightsProfiles) cr where d.sku = :sku and d.offer.id = f.id and fc.id = ci.id and cr.id = rp.id";
}
