class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {

        List<String> ans = new ArrayList<>();
        Map<String,List<Integer> > map = new HashMap<>();

        for(List<String> curr :access_times)
        {
            String emp= curr.get(0);
            String time =curr.get(1);
            if(!map.containsKey(emp))
            {
                map.put(emp,new ArrayList<>());
            }
            int t=Integer.parseInt(time);
            map.get(emp).add(t);
        }
        for(String emp:map.keySet())
        {
            List<Integer> times = map.get(emp);
            Collections.sort(times);
            if(isHighAccessed(times))
            {
                ans.add(emp);
            }
        }
        return ans;
    }
    public boolean isHighAccessed(List<Integer> times)
    {
        int n=times.size();
        for(int i=2;i<n;i++)
        {
            int currtime=times.get(i);
            int prepre=times.get(i-2);
            if(prepre +99 >=currtime)
            {
                return true;
            }
        }
        return false;

    }
}