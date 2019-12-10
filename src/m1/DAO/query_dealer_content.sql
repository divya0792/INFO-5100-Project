WITH ids AS (
    SELECT head_info_id, foot_info_id, left_info_id, right_info_id FROM Dealer d WHERE d.DealerID = ?)
SELECT 'header' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.head_info_id
UNION ALL SELECT 'footer' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.foot_info_id
UNION ALL SELECT 'left' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.left_info_id
UNION ALL SELECT 'right' as area, dc.* FROM DealerContent dc, ids WHERE dc.id = ids.right_info_id;
